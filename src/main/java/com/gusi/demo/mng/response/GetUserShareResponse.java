package com.gusi.demo.mng.response;

import java.util.List;

import com.gusi.demo.mng.model.user.UserShare;

/**
 * @author peiyu
 */
public class GetUserShareResponse extends BaseResponse {

	private List<UserShare> list;

	public List<UserShare> getList() {
		return list;
	}

	public void setList(List<UserShare> list) {
		this.list = list;
	}
}
