package com.gusi.demo.mng.response;

import java.util.List;

import com.gusi.demo.mng.model.statistic.UpstreamMsgMonth;

/**
 * @author peiyu
 */
public class GetUpstreamMsgMonthResponse extends BaseResponse {

	private List<UpstreamMsgMonth> list;

	public List<UpstreamMsgMonth> getList() {
		return list;
	}

	public void setList(List<UpstreamMsgMonth> list) {
		this.list = list;
	}
}
