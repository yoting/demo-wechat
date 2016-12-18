package com.gusi.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.gusi.demo.utils.SpringBeanUtil;

@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatConfig {

	private WechatConfig() {
	}

	public static WechatConfig getInstance() {
		// System.out.println("getInstance");
		return SpringBeanUtil.getBean(WechatConfig.class);
	}

	private String appid;
	private String appsecret;

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getAppsecret() {
		return appsecret;
	}

	public void setAppsecret(String appsecret) {
		this.appsecret = appsecret;
	}

}
