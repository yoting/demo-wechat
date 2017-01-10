package com.gusi.demo.mng.response;

import java.util.List;

import com.gusi.demo.mng.model.user.UserSummary;

/**
 * @author peiyu
 */
public class GetUserSummaryResponse extends BaseResponse {

	private List<UserSummary> list;

	public List<UserSummary> getList() {
		return list;
	}

	public void setList(List<UserSummary> list) {
		this.list = list;
	}
}
