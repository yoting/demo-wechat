package com.gusi.demo.thrid.wechat;

import com.gusi.demo.config.WechatConfig;

public class WechatAccess {
	public String getAccess() {
		String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
				+ WechatConfig.getInstance().getAppid()
				+ "&secret="
				+ WechatConfig.getInstance().getAppsecret();
		return null;
	}
}
