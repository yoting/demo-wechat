package com.gusi.demo.message;

/**
 * 消息基类（普通用户 -> 公众帐号）
 *
 */
public class BaseMessage {
	/**
	 * 消息id，64位整型
	 */
	protected long MsgId;
	/**
	 * 消息类型（text/image/location/link）
	 */
	protected String MsgType;
	/**
	 * 开发者微信号
	 */
	protected String ToUserName;
	/**
	 * 发送方帐号（一个OpenID）
	 */
	protected String FromUserName;
	/**
	 * 消息创建时间 （整型）
	 */
	protected long CreateTime;

	public String getToUserName() {
		return ToUserName;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public long getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(long createTime) {
		CreateTime = createTime;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

	public long getMsgId() {
		return MsgId;
	}

	public void setMsgId(long msgId) {
		MsgId = msgId;
	}
}
