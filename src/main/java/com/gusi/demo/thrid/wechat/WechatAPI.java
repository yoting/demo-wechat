package com.gusi.demo.thrid.wechat;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.gusi.demo.config.WechatConfig;
import com.gusi.demo.utils.HttpClientUtil;
import com.gusi.demo.utils.StaticVarUtil;

public class WechatAPI {

	public static String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	public static String ACCESS_TOKEN_CODE_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=APPSECRET&code=CODE&grant_type=authorization_code";
	public static String MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

	/**
	 * 获取微信基本信息 <br>
	 * access_token:token<br>
	 * openid:openid
	 * 
	 * @param code
	 * @return Map
	 */
	public static Map<String, String> getBaseInfo(String code) {
		Map<String, String> result = new HashMap<String, String>();
		if (code == null || code.isEmpty()) {// 获取通用token
			String urlStr = ACCESS_TOKEN_URL.replace(StaticVarUtil.WechatVar.APPID, WechatConfig.getInstance().getAppid()).replace(
					StaticVarUtil.WechatVar.APPSECRET, WechatConfig.getInstance().getAppsecret());
			String data = HttpClientUtil.executeGet(urlStr);

			if (data != null) {
				JSONObject jobj = JSONObject.parseObject(data);
				String token = jobj.getString("access_token");
				result.put("token", token);
			}
		} else {
			String urlStr = ACCESS_TOKEN_CODE_URL.replace(StaticVarUtil.WechatVar.APPID, WechatConfig.getInstance().getAppid())
					.replace(StaticVarUtil.WechatVar.APPSECRET, WechatConfig.getInstance().getAppsecret()).replace("CODE", code);
			String data = HttpClientUtil.executeGet(urlStr);

			if (data != null) {
				JSONObject jobj = JSONObject.parseObject(data);
				String token = jobj.getString("access_token");
				result.put("token", token);
				String openid = jobj.getString("openid");
				result.put("openid", openid);
			}
		}
		return result;
	}

	public static int createMenu(String token, String menuData) {
		String urlStr = MENU_URL.replace(StaticVarUtil.WechatVar.ACCESS_TOKEN, token);
		String result = HttpClientUtil.executePost(urlStr, menuData);
		System.out.println(result);
		return 0;
	}
}
