package com.gusi.demo.message;

import com.gusi.demo.utils.MessageUtil;

/**
 * 文本消息
 *
 */
public class TextMessage extends BaseMessage {
	// 消息内容
	private String Content;

	public TextMessage() {
		super();
		this.MsgType = MessageUtil.REQ_MESSAGE_TYPE_TEXT;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
}
