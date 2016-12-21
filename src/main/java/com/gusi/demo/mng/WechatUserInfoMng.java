package com.gusi.demo.mng;

import com.alibaba.fastjson.JSONObject;
import com.gusi.demo.utils.HttpClientUtil;
import com.gusi.demo.utils.StaticVarUtil;

public class WechatUserInfoMng {
	/**
	 * 获取用户信息地址
	 */
	public static final String USER_INFO_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	/**
	 * 获取用户信息地址——通过网页授权获取
	 */
	public static final String USER_INFO_AUTH_URL = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";

	public static UserInfo getUserInfoByAuth(String token, String openid) {
		String urlStr = USER_INFO_AUTH_URL.replace(StaticVarUtil.WechatVar.ACCESS_TOKEN, token).replace(StaticVarUtil.WechatVar.OPENID,
				openid);
		String data = HttpClientUtil.executeGet(urlStr);

		if (data != null) {
			JSONObject jobj = JSONObject.parseObject(data);
			String nickname = jobj.getString("nickname");
			int sex = jobj.getInteger("sex");
			String province = jobj.getString("province");
			String city = jobj.getString("city");
			String country = jobj.getString("country");
			String headimgurl = jobj.getString("headimgurl");
			String privilege = jobj.getString("privilege");
			String unionid = jobj.getString("unionid");

			UserInfo userinfo = new WechatUserInfoMng().new UserInfo(openid, nickname, sex, province, city, country, headimgurl, privilege,
					unionid);
			return userinfo;
		}
		return null;
	}

	public static UserInfo getUserInfoByFouse(String token, String openid) {
		String urlStr = USER_INFO_URL.replace(StaticVarUtil.WechatVar.ACCESS_TOKEN, token).replace(StaticVarUtil.WechatVar.OPENID, openid);
		String data = HttpClientUtil.executeGet(urlStr);

		if (data != null) {
			JSONObject jobj = JSONObject.parseObject(data);
			String nickname = jobj.getString("nickname");
			int sex = jobj.getInteger("sex");
			String province = jobj.getString("province");
			String city = jobj.getString("city");
			String country = jobj.getString("country");
			String headimgurl = jobj.getString("headimgurl");
			String privilege = jobj.getString("privilege");
			String unionid = jobj.getString("unionid");

			long subscribe_time = jobj.getLong("subscribe_time");
			String remark = jobj.getString("remark");
			String groupid = jobj.getString("groupid");

			UserInfo userinfo = new WechatUserInfoMng().new UserInfo(openid, nickname, sex, province, city, country, headimgurl, privilege,
					unionid, subscribe_time, remark, groupid);
			return userinfo;
		}

		return null;
	}

	public class UserInfo {
		private String openid;// 用户的唯一标识
		private String nickname;// 用户昵称
		private int sex;// 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
		private String province;// 用户个人资料填写的省份
		private String city;// 普通用户个人资料填写的城市
		private String country;// 国家，如中国为CN
		private String headimgurl;// 用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。
		private String privilege;// 用户特权信息，json 数组，如微信沃卡用户为（chinaunicom）
		private String unionid;// 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。

		// 关注用户才有的信息
		private long subscribe_time;// 用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间
		private String remark;// 公众号运营者对粉丝的备注，公众号运营者可在微信公众平台用户管理界面对粉丝添加备注
		private String groupid;// 用户所在的分组ID

		public UserInfo(String openid, String nickname, int sex, String province, String city, String country, String headimgurl,
				String privilege, String unionid) {
			super();
			this.openid = openid;
			this.nickname = nickname;
			this.sex = sex;
			this.province = province;
			this.city = city;
			this.country = country;
			this.headimgurl = headimgurl;
			this.privilege = privilege;
			this.unionid = unionid;
		}

		public UserInfo(String openid, String nickname, int sex, String province, String city, String country, String headimgurl,
				String privilege, String unionid, long subscribe_time, String remark, String groupid) {
			super();
			this.openid = openid;
			this.nickname = nickname;
			this.sex = sex;
			this.province = province;
			this.city = city;
			this.country = country;
			this.headimgurl = headimgurl;
			this.privilege = privilege;
			this.unionid = unionid;
			this.subscribe_time = subscribe_time;
			this.remark = remark;
			this.groupid = groupid;
		}

		public String getOpenid() {
			return openid;
		}

		public void setOpenid(String openid) {
			this.openid = openid;
		}

		public String getNickname() {
			return nickname;
		}

		public void setNickname(String nickname) {
			this.nickname = nickname;
		}

		public int getSex() {
			return sex;
		}

		public void setSex(int sex) {
			this.sex = sex;
		}

		public String getProvince() {
			return province;
		}

		public void setProvince(String province) {
			this.province = province;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String getHeadimgurl() {
			return headimgurl;
		}

		public void setHeadimgurl(String headimgurl) {
			this.headimgurl = headimgurl;
		}

		public String getPrivilege() {
			return privilege;
		}

		public void setPrivilege(String privilege) {
			this.privilege = privilege;
		}

		public String getUnionid() {
			return unionid;
		}

		public void setUnionid(String unionid) {
			this.unionid = unionid;
		}

		public long getSubscribe_time() {
			return subscribe_time;
		}

		public void setSubscribe_time(long subscribe_time) {
			this.subscribe_time = subscribe_time;
		}

		public String getRemark() {
			return remark;
		}

		public void setRemark(String remark) {
			this.remark = remark;
		}

		public String getGroupid() {
			return groupid;
		}

		public void setGroupid(String groupid) {
			this.groupid = groupid;
		}

		@Override
		public String toString() {
			return "UserInfo [openid=" + openid + ", nickname=" + nickname + ", sex=" + sex + ", province=" + province + ", city=" + city
					+ ", country=" + country + ", headimgurl=" + headimgurl + ", privilege=" + privilege + ", unionid=" + unionid
					+ ", subscribe_time=" + subscribe_time + ", remark=" + remark + ", groupid=" + groupid + "]";
		}

	}
}
