package com.gusi.demo.mng.response;

import java.util.List;

import com.gusi.demo.mng.model.statistic.UpstreamMsgDistMonth;

/**
 * @author peiyu
 */
public class GetUpstreamMsgDistMonthResponse extends BaseResponse {

	private List<UpstreamMsgDistMonth> list;

	public List<UpstreamMsgDistMonth> getList() {
		return list;
	}

	public void setList(List<UpstreamMsgDistMonth> list) {
		this.list = list;
	}
}
