package com.server.controller;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by xiaofengfu on 2017/8/8.
 */
@SpringBootApplication
@EnableEurekaServer
public class ServerApp {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(ServerApp.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
    }
}
