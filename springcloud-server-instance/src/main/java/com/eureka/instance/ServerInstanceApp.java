package com.eureka.instance;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by xiaofengfu on 2017/8/8.
 */
@EnableEurekaClient
@SpringBootApplication
public class ServerInstanceApp {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(ServerInstanceApp.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
    }
}
