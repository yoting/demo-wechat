package com.gusi.demo.mng.response;

import java.util.List;

import com.gusi.demo.mng.model.user.UserRead;

/**
 * @author peiyu
 */
public class GetUserReadResponse extends BaseResponse {

	private List<UserRead> list;

	public List<UserRead> getList() {
		return list;
	}

	public void setList(List<UserRead> list) {
		this.list = list;
	}
}
