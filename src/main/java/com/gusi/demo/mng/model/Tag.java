package com.gusi.demo.mng.model;

import com.gusi.demo.mng.model.base.BaseModel;

/**
 * 标签对象
 * 
 * @author dyy_gusi
 * @date 2017年1月10日上午11:23:52
 *
 */

public class Tag extends BaseModel {

	private Integer id;

	private String name;

	private Integer count;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
}
