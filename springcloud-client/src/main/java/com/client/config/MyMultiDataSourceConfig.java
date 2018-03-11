package com.client.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
//@ConditionalOnClass({ DataSource.class, EmbeddedDatabaseType.class })
public class MyMultiDataSourceConfig {

//	@Bean
//	@Primary
//	@ConfigurationProperties("spring.datasource")
//	public DataSourceProperties dataSourceProperties() {
//		return new DataSourceProperties();
//	}
//
//	@Bean("secondDatasource")
//	@ConfigurationProperties("spring.second-datasource")
//	public DataSourceProperties secondDataSourceProperties() {
//		return new DataSourceProperties();
//	}

	@Primary   // 配置默认数据源
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource primaryDataSource() {
		//return dataSourceProperties().initializeDataSourceBuilder().build();
		return DataSourceBuilder.create().build();
	}

	@Primary //配置默认jdbcTemplate
	@Bean
	public JdbcTemplate defaultJdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean("secondDataSource")
	@ConfigurationProperties("spring.second-datasource")
	public DataSource secondDataSource() {
		return DataSourceBuilder.create().build();
		//return secondDataSourceProperties().initializeDataSourceBuilder().build();
	}

	@Bean("secondJdbcTemplate")
	public JdbcTemplate jdbcTemplate1(@Qualifier("secondDataSource") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
}
