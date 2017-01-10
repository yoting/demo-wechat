package com.gusi.demo.mng.request;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

/**
 * 简单参数请求对象
 * 
 * @author dyy_gusi
 * @date 2016年12月29日下午12:03:05
 *
 */
public class SimpleParamReq extends CommonReq {
	private Map<String, Object> param = new HashMap<String, Object>();

	public void putParam(String key, Object value) {
		param.put(key, value);
	}

	public String getParamJson() {
		String data = JSONObject.toJSONString(param);
		return data;
	}

	public static void main(String[] args) {

		SimpleParamReq paramReq = new SimpleParamReq();

		paramReq.putParam("a", 1);
		paramReq.putParam("b", "2");
		paramReq.putParam("d", new String[] { "1", "2" });

		String data = JSONObject.toJSONString(paramReq.getParamJson());
		System.out.println(data);
	}
}
