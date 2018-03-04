package com.client.start;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

/**
 * Created by xiaofengfu on 2017/8/8.
 */
//@EnableTurbine
//@EnableEurekaClient  //如果要使用eureka服务发现，请将此注释打开
@EnableCircuitBreaker
@EnableHystrixDashboard
@EnableFeignClients(basePackages = {"com.client.feignclient"})
@MapperScan("com.client.mybatis")
@SpringBootApplication//(scanBasePackages = {"com.client.controller"})
@ComponentScans(@ComponentScan({"com.client.config","com.client.controller","com.client.service"}))
public class ClientApp {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(ClientApp.class);
		springApplication.setBannerMode(Banner.Mode.OFF);
		springApplication.run(args);
	}


}