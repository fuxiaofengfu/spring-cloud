package com.eureka.instance.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiaofengfu on 2017/8/12.
 */
@RestController
public class EurekaController {

    @GetMapping("eureka-instance")
    public String eurekainstance(){
        System.out.println("eureka-instance....");
        return "eureka-instance";
    }
}
