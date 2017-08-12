package com.server.controller;

import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiaofengfu on 2017/8/8.
 */
@RestController
public class EurekaServerController {

    @GetMapping("/eureka1")
    public String server(){
        return "我。。eureka server1  run .....";
    }

    @GetMapping("/eureka2")
    public String server2(){
        return "我。2。eureka server1  run .....";
    }
}
