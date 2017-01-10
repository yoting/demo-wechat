package com.gusi.demo.mng.response;

import java.util.List;

import com.gusi.demo.mng.model.UpstreamMsgDist;

/**
 * @author peiyu
 */
public class GetUpstreamMsgDistResponse extends BaseResponse {

	private List<UpstreamMsgDist> list;

	public List<UpstreamMsgDist> getList() {
		return list;
	}

	public void setList(List<UpstreamMsgDist> list) {
		this.list = list;
	}
}
