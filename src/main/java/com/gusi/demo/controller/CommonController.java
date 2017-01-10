package com.gusi.demo.controller;

import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.gusi.demo.config.WechatConfig;
import com.gusi.demo.mng.WechatMenuMng;
import com.gusi.demo.mng.WechatTokenMng;
import com.gusi.demo.mng.WechatTokenMng.TokenCache;
import com.gusi.demo.mng.WechatUserInfoMng;
import com.gusi.demo.mng.WechatUserInfoMng.UserInfo;
import com.gusi.demo.mng.model.menu.Menu;
import com.gusi.demo.mng.model.menu.MenuSpecial;

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
		if (id == 0) {
			Map<String, String> cfg = new TreeMap<String, String>();
			cfg.put("1", "create menu");
			cfg.put("2", "create menu special");
			cfg.put("3", "query menu");

			return JSONObject.toJSONString(cfg, true);
		} else if (id == 1) {
			WechatMenuMng.createMenu(WechatTokenMng.getAccessToken().getToken(), Menu.getDemoMenu());
			return "create menu success!";
		} else if (id == 2) {
			WechatMenuMng.createMenuSpecial(WechatTokenMng.getAccessToken().getToken(), MenuSpecial.getDemoMenuSpecial());
			return "create menu special success!";
		} else if (id == 3) {
			String menuData = WechatMenuMng.queryMenu(WechatTokenMng.getAccessToken().getToken());
			return menuData;
		} else {
			return "no commnd find!";
		}
	}

	@RequestMapping("/business")
	public String business(@RequestParam(name = "code", required = false, defaultValue = "") String code,
			@RequestParam(name = "state", required = false, defaultValue = "") String state) {
		System.out.println(code);
		TokenCache token = WechatTokenMng.getAccessTokenByCode(code);
		System.out.println(token);
		UserInfo userinfo = WechatUserInfoMng.getUserInfoByAuth(token.getToken(), token.getOpenid());
		System.out.println(userinfo);
		return "sucess->code:" + code + ";state:" + state;
	}

	@RequestMapping("/userinfo/{code}")
	public String getUserInfo(@PathVariable(name = "code") String code) {
		TokenCache token = WechatTokenMng.getAccessTokenByCode(code);
		UserInfo userinfo = WechatUserInfoMng.getUserInfoByAuth(token.getToken(), token.getOpenid());
		String openid = userinfo.getOpenid();
		return "get user info success!\r\n token:" + token.getToken() + ";openid:" + openid;
	}
}
