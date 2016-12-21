package com.gusi.demo.mng;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.gusi.demo.config.WechatConfig;
import com.gusi.demo.utils.HttpClientUtil;
import com.gusi.demo.utils.StaticVarUtil;

public class WechatTokenMng {
	public static String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	public static String ACCESS_TOKEN_CODE_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=APPSECRET&code=CODE&grant_type=authorization_code";
	public static String ACCESS_TOKEN_REFUSH_URL = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN";
	public static String ACCESS_TOKEN_VERIFY_URL = "https://api.weixin.qq.com/sns/auth?access_token=ACCESS_TOKEN&openid=OPENID";

	public static TokenCache tokenCahch;// 普通access_token
	public static Map<String, TokenCache> tokenMap = new HashMap<String, WechatTokenMng.TokenCache>();// 网页授权access_token，每个用户的token不同

	public static TokenCache getAccessToken() {
		if (tokenCahch != null && tokenCahch.isExpires()) {
			return tokenCahch;
		} else {
			String urlStr = ACCESS_TOKEN_URL.replace(StaticVarUtil.WechatVar.APPID, WechatConfig.getInstance().getAppid()).replace(
					StaticVarUtil.WechatVar.APPSECRET, WechatConfig.getInstance().getAppsecret());
			String data = HttpClientUtil.executeGet(urlStr);

			if (data != null) {
				JSONObject jobj = JSONObject.parseObject(data);
				String access_token = jobj.getString("access_token");
				int expires_in = jobj.getInteger("expires_in");
				tokenCahch = new WechatTokenMng().new TokenCache(access_token, expires_in);
			}
			return tokenCahch;
		}
	}

	public static TokenCache getAccessTokenByCode(String code) {
		TokenCache token = tokenMap.get(code);// 网页认证access_toke
		if (token == null) {
			String urlStr = ACCESS_TOKEN_CODE_URL.replace(StaticVarUtil.WechatVar.APPID, WechatConfig.getInstance().getAppid())
					.replace(StaticVarUtil.WechatVar.APPSECRET, WechatConfig.getInstance().getAppsecret()).replace("CODE", code);
			String data = HttpClientUtil.executeGet(urlStr);

			if (data != null) {
				JSONObject jobj = JSONObject.parseObject(data);
				String access_token = jobj.getString("access_token");
				String openid = jobj.getString("openid");
				String refresh_token = jobj.getString("refresh_token");
				String scope = jobj.getString("scope");

				int expires_in = jobj.getInteger("expires_in");
				// expires_in = 30;

				if (verifyAuthToken(access_token, openid)) {
					token = new WechatTokenMng().new TokenCache(access_token, refresh_token, expires_in, openid, scope);
					tokenMap.put(code, token);
					return token;
				}
			}
		} else if (!token.isExpires()) {// 过期
			if (token.isRefresh()) {// 已经刷新过，不能再刷新
				return null;
			}
			String urlStr = ACCESS_TOKEN_REFUSH_URL.replace(StaticVarUtil.WechatVar.APPID, WechatConfig.getInstance().getAppid()).replace(
					"REFRESH_TOKEN", token.getTokenBak());
			String data = HttpClientUtil.executeGet(urlStr);

			if (data != null) {
				JSONObject jobj = JSONObject.parseObject(data);
				String access_token = jobj.getString("access_token");
				String openid = jobj.getString("openid");
				String refresh_token = jobj.getString("refresh_token");
				String scope = jobj.getString("scope");
				int expires_in = jobj.getInteger("expires_in");

				if (verifyAuthToken(access_token, openid)) {
					token = new WechatTokenMng().new TokenCache(refresh_token, refresh_token, expires_in, openid, scope);
					tokenMap.put(code, token);
					return token;
				}
			}
		} else {
			return token;
		}

		return null;
	}

	private static boolean verifyAuthToken(String token, String openid) {
		String urlStr = ACCESS_TOKEN_VERIFY_URL.replace(StaticVarUtil.WechatVar.ACCESS_TOKEN, token).replace(
				StaticVarUtil.WechatVar.OPENID, openid);
		String data = HttpClientUtil.executeGet(urlStr);
		if (data != null) {
			JSONObject jobj = JSONObject.parseObject(data);
			int errcode = jobj.getInteger("errcode");
			return errcode == 0;
		}

		return false;
	}

	public class TokenCache {
		private String token;
		private String tokenBak;// 刷新的token，如果已经刷新过，token和tokenBak相同
		private String openid;
		private long tokenDeadline;
		private String scope;

		public TokenCache(String access_token, int expires_in) {
			super();
			this.token = access_token;
			this.tokenDeadline = System.currentTimeMillis() + (expires_in * 1000L) - (1000 * 60 * 10L);// 过期时间设置
		}

		public TokenCache(String access_token, String refresh_token, int expires_in, String openid, String scope) {
			super();
			this.token = access_token;
			this.tokenBak = refresh_token;
			this.openid = openid;
			this.scope = scope;
			this.tokenDeadline = System.currentTimeMillis() + (expires_in * 1000L) - (1000 * 60 * 10L);// 过期时间设置
		}

		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}

		public String getOpenid() {
			return openid;
		}

		public void setOpenid(String openid) {
			this.openid = openid;
		}

		public String getTokenBak() {
			return tokenBak;
		}

		public void setTokenBak(String tokenBak) {
			this.tokenBak = tokenBak;
		}

		public long getTokenDeadline() {
			return tokenDeadline;
		}

		public void setTokenDeadline(long tokenDeadline) {
			this.tokenDeadline = tokenDeadline;
		}

		public String getScope() {
			return scope;
		}

		public void setScope(String scope) {
			this.scope = scope;
		}

		/**
		 * 判断token是否过期
		 * 
		 * @return 过期：false<br>
		 *         有效：true
		 */
		public boolean isExpires() {
			return System.currentTimeMillis() < this.tokenDeadline;
		}

		/**
		 * 判断token是否刷新过
		 * 
		 * @return 已刷新：true<br>
		 *         未刷新：false
		 */
		public boolean isRefresh() {
			return this.token.equals(this.tokenBak);
		}

		@Override
		public String toString() {
			return "TokenCache [token=" + token + ", tokenBak=" + tokenBak + ", openid=" + openid + ", tokenDeadline=" + tokenDeadline
					+ ", scope=" + scope + "]";
		}

	}

}
