package com.client.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiaofengfu on 2017/8/12.
 */
@RestController
public class ServerController {

    @Autowired
    FeignClientController feignClientController;

    @GetMapping("c1")
    @HystrixCommand(fallbackMethod = "serverDead")
    public String c1(){
        System.out.println("feignClientController.....");
        return feignClientController.testeur();
    }

    public String serverDead(){
        System.out.println("serverDead.......");
        return "serverDead....";
    }
}
