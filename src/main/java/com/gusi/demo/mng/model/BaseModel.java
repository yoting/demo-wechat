package com.gusi.demo.mng.model;

import com.alibaba.fastjson.JSONObject;

/**
 * 抽象实体类
 *
 * @author peiyu
 */
public abstract class BaseModel implements Model {
	@Override
	public String toJsonString() {
		return JSONObject.toJSONString(this);
	}
}
