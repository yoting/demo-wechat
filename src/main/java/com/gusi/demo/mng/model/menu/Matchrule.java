package com.gusi.demo.mng.model.menu;

public class Matchrule {
	private String tag_id;// ":"2",
	private int sex;// ":"1",
	private String country;// ":"中国",
	private String province;// ":"广东",
	private String city;// ":"广州",
	private String client_platform_type;// ":"2",
	private String language;// ":"zh_CN"

	public String getTag_id() {
		return tag_id;
	}

	public void setTag_id(String tag_id) {
		this.tag_id = tag_id;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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

	public String getClient_platform_type() {
		return client_platform_type;
	}

	public void setClient_platform_type(String client_platform_type) {
		this.client_platform_type = client_platform_type;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public String toString() {
		return "Matchrule [tag_id=" + tag_id + ", sex=" + sex + ", country=" + country + ", province=" + province + ", city=" + city
				+ ", client_platform_type=" + client_platform_type + ", language=" + language + "]";
	}

}
