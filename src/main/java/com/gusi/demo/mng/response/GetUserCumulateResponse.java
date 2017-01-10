package com.gusi.demo.mng.response;

import java.util.List;

import com.gusi.demo.mng.model.user.UserCumulate;

/**
 * @author peiyu
 */
public class GetUserCumulateResponse extends BaseResponse {

	private List<UserCumulate> list;

	public List<UserCumulate> getList() {
		return list;
	}

	public void setList(List<UserCumulate> list) {
		this.list = list;
	}
}
