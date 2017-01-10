package com.gusi.demo.mng.response;

import java.util.List;

import com.gusi.demo.mng.model.statistic.InterfaceSummary;

/**
 * @author peiyu
 */
public class GetInterfaceSummaryResponse extends BaseResponse {

	private List<InterfaceSummary> list;

	public List<InterfaceSummary> getList() {
		return list;
	}

	public void setList(List<InterfaceSummary> list) {
		this.list = list;
	}
}
