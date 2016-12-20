package com.gusi.demo.thrid.wechat;

import com.alibaba.fastjson.JSONObject;
import com.gusi.demo.config.WechatConfig;
import com.gusi.demo.menu.Menu;
import com.gusi.demo.utils.HttpClientUtil;

public class WechatAPI {
	public static final String APPID = "APPID";
	public static final String APPSECRET = "APPSECRET";
	public static final String ACCESS_TOKEN = "ACCESS_TOKEN";
	public static String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	public static String ACCESS_TOKEN_CODE_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=APPSECRET&code=CODE&grant_type=authorization_code";
	public static String MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

	public static String getAccessToken(String code) {
		if (code == null || code.isEmpty()) {
			String urlStr = ACCESS_TOKEN_URL.replace(APPID, WechatConfig.getInstance().getAppid()).replace(APPSECRET,
					WechatConfig.getInstance().getAppsecret());
			String result = HttpClientUtil.executeGet(urlStr);

			if (result != null) {
				JSONObject jobj = JSONObject.parseObject(result);
				String token = jobj.getString("access_token");
				return token;
			}
		} else {
			String urlStr = ACCESS_TOKEN_CODE_URL.replace(APPID, WechatConfig.getInstance().getAppid())
					.replace(APPSECRET, WechatConfig.getInstance().getAppsecret()).replace("CODE", code);
			String result = HttpClientUtil.executeGet(urlStr);

			if (result != null) {
				JSONObject jobj = JSONObject.parseObject(result);
				String token = jobj.getString("access_token");
				return token;
			}

		}
		return null;
	}

	public static int createMenu(String token, String menuData) {
		String urlStr = MENU_URL.replace(ACCESS_TOKEN, getAccessToken(null));
		String result = HttpClientUtil.executePost(urlStr, Menu.getDemoMenu());
		return 0;
	}
}
