package com.gusi.demo.mng.response;

import java.util.List;

import com.gusi.demo.mng.model.InterfaceSummaryHour;

/**
 * @author peiyu
 */
public class GetInterfaceSummaryHourResponse extends BaseResponse {

	private List<InterfaceSummaryHour> list;

	public List<InterfaceSummaryHour> getList() {
		return list;
	}

	public void setList(List<InterfaceSummaryHour> list) {
		this.list = list;
	}
}
