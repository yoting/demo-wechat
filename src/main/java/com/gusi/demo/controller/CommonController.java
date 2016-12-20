package com.gusi.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gusi.demo.config.WechatConfig;
import com.gusi.demo.menu.Menu;
import com.gusi.demo.thrid.wechat.WechatAPI;

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

	@RequestMapping("/cfg/{id}")
	public String config(@PathVariable("id") int id) {
		if (id == 1) {
			WechatAPI.createMenu(WechatAPI.getBaseInfo(null).get("token"),
					Menu.getDemoMenu());
			return "create menu success!";
		} else {
			return "no commnd find!";
		}
	}

	@RequestMapping("/business")
	public String business(
			@RequestParam(name = "code", required = false, defaultValue = "") String code,
			@RequestParam(name = "state", required = false, defaultValue = "") String state) {
		System.out.println(code);
		return "sucess->code:" + code + ";state:" + state;
	}

	@RequestMapping("/userinfo/{code}")
	public String getUserInfo(@PathVariable(name = "code") String code) {
		Map<String, String> data = WechatAPI.getBaseInfo(code);
		String token = data.get("token");
		String openid = data.get("openid");
		return "get user info success!\r\n token:" + token + ";openid:"
				+ openid;
	}
}
