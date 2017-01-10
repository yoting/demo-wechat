package com.gusi.demo.mng.response;

import java.util.List;

import com.gusi.demo.mng.model.user.UserReadHour;

/**
 * @author peiyu
 */
public class GetUserReadHourResponse extends BaseResponse {

	private List<UserReadHour> list;

	public List<UserReadHour> getList() {
		return list;
	}

	public void setList(List<UserReadHour> list) {
		this.list = list;
	}
}
