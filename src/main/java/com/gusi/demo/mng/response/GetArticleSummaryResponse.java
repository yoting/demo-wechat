package com.gusi.demo.mng.response;

import java.util.List;

import com.gusi.demo.mng.model.statistic.ArticleSummary;

/**
 * @author peiyu
 */
public class GetArticleSummaryResponse extends BaseResponse {

	private List<ArticleSummary> list;

	public List<ArticleSummary> getList() {
		return list;
	}

	public void setList(List<ArticleSummary> list) {
		this.list = list;
	}
}
