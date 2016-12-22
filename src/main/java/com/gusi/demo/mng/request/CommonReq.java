package com.gusi.demo.mng.request;

public class CommonReq {
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "CommonReq [token=" + token + "]";
	}

}
