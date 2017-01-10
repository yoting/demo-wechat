package com.gusi.demo.mng.response;

import java.util.List;

import com.gusi.demo.mng.model.user.UserShareHour;

/**
 * @author peiyu
 */
public class GetUserShareHourResponse extends BaseResponse {

	private List<UserShareHour> list;

	public List<UserShareHour> getList() {
		return list;
	}

	public void setList(List<UserShareHour> list) {
		this.list = list;
	}
}
