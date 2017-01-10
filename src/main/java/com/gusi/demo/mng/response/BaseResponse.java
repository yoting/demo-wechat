package com.gusi.demo.mng.response;

import com.gusi.demo.enums.ResultType;
import com.gusi.demo.mng.model.base.BaseModel;
import com.gusi.demo.utils.BeanUtil;
import com.gusi.demo.utils.StringUtil;

/**
 * 微信API响应报文对象基类
 *
 * @author peiyu
 */
public class BaseResponse extends BaseModel {

	private String errcode;
	private String errmsg;

	public String getErrcode() {
		return errcode;
	}

	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		String result = this.errmsg;
		// 将接口返回的错误信息转换成中文，方便提示用户出错原因
		if (StringUtil.isNotBlank(this.errcode) && !ResultType.SUCCESS.getCode().toString().equals(this.errcode)) {
			ResultType resultType = ResultType.get(this.errcode);
			if (BeanUtil.nonNull(resultType)) {
				result = resultType.getDescription();
			}
		}
		return result;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
}
