package com.gusi.demo.mng.response;

import java.util.List;

import com.gusi.demo.mng.model.statistic.UpstreamMsgHour;

/**
 * @author peiyu
 */
public class GetUpstreamMsgHourResponse extends BaseResponse {

	private List<UpstreamMsgHour> list;

	public List<UpstreamMsgHour> getList() {
		return list;
	}

	public void setList(List<UpstreamMsgHour> list) {
		this.list = list;
	}
}
