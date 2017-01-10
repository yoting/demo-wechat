package com.gusi.demo.mng.model.statistic;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 接口调运统计——分小时统计
 * 
 * @author dyy_gusi
 * @date 2017年1月10日上午11:25:15
 *
 */
public class InterfaceSummaryHour extends InterfaceSummary {

	@JSONField(name = "ref_hour")
	private Integer refHour;

	public Integer getRefHour() {
		return refHour;
	}

	public void setRefHour(Integer refHour) {
		this.refHour = refHour;
	}
}
