package com.gusi.demo.mng.response;

import java.util.List;

import com.gusi.demo.mng.model.statistic.ArticleTotal;

/**
 * @author peiyu
 */
public class GetArticleTotalResponse extends BaseResponse {

	private List<ArticleTotal> list;

	public List<ArticleTotal> getList() {
		return list;
	}

	public void setList(List<ArticleTotal> list) {
		this.list = list;
	}
}
