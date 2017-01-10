package com.gusi.demo.mng;

import com.gusi.demo.mng.request.SimpleParamReq;
import com.gusi.demo.utils.HttpClientJDKUtil;
import com.gusi.demo.utils.StaticVarUtil;

/**
 * 菜单栏管理
 * 
 * @author dyy_gusi
 * @date 2016年12月22日上午11:40:56
 *
 */
public class WechatMenuMng {
	public static String MENU_QUERY_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";

	public static String MENU_CREATE_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	public static String MENU_DELETE_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";

	public static String MENU_CREATE_SPECIAL_URL = "https://api.weixin.qq.com/cgi-bin/menu/addconditional?access_token=ACCESS_TOKEN";
	public static String MENU_DELETE_SPECIAL_URL = "https://api.weixin.qq.com/cgi-bin/menu/delconditional?access_token=ACCESS_TOKEN";

	public static String MENU_MATCH_URL = "https://api.weixin.qq.com/cgi-bin/menu/trymatch?access_token=ACCESS_TOKEN";

	public static String queryMenu(String token) {
		String urlStr = MENU_QUERY_URL.replace(StaticVarUtil.WechatVar.ACCESS_TOKEN, token);
		String data = HttpClientJDKUtil.executeGet(urlStr);
		System.out.println(data);
		return data;
	}

	public static void createMenu(String token, String menuData) {
		String urlStr = MENU_CREATE_URL.replace(StaticVarUtil.WechatVar.ACCESS_TOKEN, token);
		String data = HttpClientJDKUtil.executePost(urlStr, menuData);
		System.out.println(data);
		return;
	}

	public static void deleteMenu(String token) {
		String urlStr = MENU_DELETE_URL.replace(StaticVarUtil.WechatVar.ACCESS_TOKEN, token);
		String data = HttpClientJDKUtil.executeGet(urlStr);
		System.out.println(data);
		return;
	}

	public static void createMenuSpecial(String token, String menuData) {
		String urlStr = MENU_CREATE_SPECIAL_URL.replace(StaticVarUtil.WechatVar.ACCESS_TOKEN, token);
		String data = HttpClientJDKUtil.executePost(urlStr, menuData);
		System.out.println(data);
		return;
	}

	public static void deleteMenuSpecial(SimpleParamReq param) {
		String urlStr = MENU_DELETE_SPECIAL_URL.replace(StaticVarUtil.WechatVar.ACCESS_TOKEN, param.getToken());
		String data = HttpClientJDKUtil.executePost(urlStr, param.getParamJson());
		System.out.println(data);
		return;
	}

	public static void matchMenu(SimpleParamReq param) {
		String urlStr = MENU_MATCH_URL.replace(StaticVarUtil.WechatVar.ACCESS_TOKEN, param.getToken());
		String data = HttpClientJDKUtil.executePost(urlStr, param.getParamJson());
		System.out.println(data);
		return;
	}
}
