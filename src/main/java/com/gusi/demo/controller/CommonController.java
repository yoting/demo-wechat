package com.gusi.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gusi.demo.config.WechatConfig;

@RestController
public class CommonController {
	@Autowired
	private WechatConfig wechatConfig;

	@RequestMapping("/")
	public String index() {
		return "hello wechat!";
	}

	@RequestMapping("/test")
	public String test() {
		System.out.println(wechatConfig.getAppid());
		return "test";
	}
}
