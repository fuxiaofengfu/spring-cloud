package com.client.controller;

import com.alibaba.fastjson.JSON;
import com.client.feignclient.FeignClientController;
import com.client.mybatis.domain.AgreementBase;
import com.client.service.AgreementBaseService;
import com.github.pagehelper.PageInfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by xiaofengfu on 2017/8/12.
 */
@RestController
public class ServerController {

	@Autowired
	FeignClientController feignClientController;

	@Autowired
	AgreementBaseService agreementBaseService;

	@GetMapping("c1")
	@HystrixCommand(fallbackMethod = "serverDead")
	public String c1() {
		System.out.println("feignClientController.....");
		return feignClientController.testeur();
	}

	public String serverDead() {
		System.out.println("serverDead.......");
		return "serverDead....";
	}

	@GetMapping("get_agreement_all")
	public List<AgreementBase> getAll() {

		List<AgreementBase> all = agreementBaseService.getAll();
		return all;
	}

	@GetMapping("getPageAll")
	public String getPageAll(int pageNo,int pageSize) {

		PageInfo<AgreementBase> page = agreementBaseService.getPageAll(pageSize,pageNo);
		return JSON.toJSONString(page,true);
	}
}
