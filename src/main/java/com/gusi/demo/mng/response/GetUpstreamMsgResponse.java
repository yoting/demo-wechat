package com.gusi.demo.mng.response;

import java.util.List;

import com.gusi.demo.mng.model.statistic.UpstreamMsg;

/**
 * @author peiyu
 */
public class GetUpstreamMsgResponse extends BaseResponse {

	private List<UpstreamMsg> list;

	public List<UpstreamMsg> getList() {
		return list;
	}

	public void setList(List<UpstreamMsg> list) {
		this.list = list;
	}
}
