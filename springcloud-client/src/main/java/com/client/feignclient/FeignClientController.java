package com.client.feignclient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by xiaofengfu on 2017/8/8.
 */
@FeignClient("eureka-server-instance1")
public interface FeignClientController {

	@GetMapping("/eureka-instance")
	public String testeur();
}
