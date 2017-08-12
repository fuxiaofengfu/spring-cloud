package com.client.controller;

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
    public String c1(){
        System.out.println("feignClientController.....");
        return feignClientController.testeur();
    }

}
