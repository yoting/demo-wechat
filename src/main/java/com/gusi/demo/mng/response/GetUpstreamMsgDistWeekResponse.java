package com.gusi.demo.mng.response;

import java.util.List;

import com.gusi.demo.mng.model.statistic.UpstreamMsgDistWeek;

/**
 * @author peiyu
 */
public class GetUpstreamMsgDistWeekResponse extends BaseResponse {

	private List<UpstreamMsgDistWeek> list;

	public List<UpstreamMsgDistWeek> getList() {
		return list;
	}

	public void setList(List<UpstreamMsgDistWeek> list) {
		this.list = list;
	}
}
