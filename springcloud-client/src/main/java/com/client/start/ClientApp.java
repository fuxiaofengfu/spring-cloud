package com.client.start;

import com.client.config.MyMultiDataSourceConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.sql.DataSource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaofengfu on 2017/8/8.
 */
//@EnableTurbine
@EnableEurekaClient  //如果要使用eureka服务发现，请将此注释打开
@EnableCircuitBreaker
@EnableHystrixDashboard
@EnableFeignClients(basePackages = {"com.client.feignclient"})
@SpringBootApplication//(exclude = { DataSourceAutoConfiguration.class })//(scanBasePackages = {"com.client.controller"})
@ComponentScans(@ComponentScan({"com.client.config", "com.client.controller", "com.client.service"}))
//@Import(MyMultiDataSourceConfig.class)
public class ClientApp extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(ClientApp.class);
		springApplication.setBannerMode(Banner.Mode.OFF);
		springApplication.run(args);
	}

	//	@Bean
//	public HttpMessageConverters fastJsonHttpMessageConverters(){
//		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();//2
//
//		FastJsonConfig fastJsonConfig = new FastJsonConfig();
//		fastJsonConfig.setSerializerFeatures(
//				SerializerFeature.PrettyFormat,
//				SerializerFeature.WriteClassName
//		);
//		fastConverter.setFastJsonConfig(fastJsonConfig);
//
//		HttpMessageConverter<?> converter = fastConverter;
//
//		return new HttpMessageConverters(converter);
//	}
	@Bean
	public MappingJackson2HttpMessageConverter getMappingJackson2HttpMessageConverter() {
		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		//设置日期格式
		ObjectMapper objectMapper = new ObjectMapper();
		SimpleDateFormat smt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		objectMapper.setDateFormat(smt);
		mappingJackson2HttpMessageConverter.setObjectMapper(objectMapper);
		//设置中文编码格式
		List<MediaType> list = new ArrayList<>();
		list.add(MediaType.APPLICATION_JSON_UTF8);
		list.add(MediaType.TEXT_HTML);
		mappingJackson2HttpMessageConverter.setSupportedMediaTypes(list);
		return mappingJackson2HttpMessageConverter;
	}

	/**
	 * {@inheritDoc}
	 * <p>This implementation is empty.
	 *
	 * @param converters
	 */
	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		super.extendMessageConverters(converters);
	}
}
