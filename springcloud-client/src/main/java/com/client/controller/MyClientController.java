package com.client.controller;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiaofengfu on 2017/8/8.
 */
@FeignClient("eureka-server-instance1")
public interface MyClientController {

    @GetMapping("/eureka2")
    public String testeur();
}
