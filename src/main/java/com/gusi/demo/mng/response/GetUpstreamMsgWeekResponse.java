package com.gusi.demo.mng.response;

import java.util.List;

import com.gusi.demo.mng.model.statistic.UpstreamMsgWeek;

/**
 * @author peiyu
 */
public class GetUpstreamMsgWeekResponse extends BaseResponse {

	private List<UpstreamMsgWeek> list;

	public List<UpstreamMsgWeek> getList() {
		return list;
	}

	public void setList(List<UpstreamMsgWeek> list) {
		this.list = list;
	}
}
