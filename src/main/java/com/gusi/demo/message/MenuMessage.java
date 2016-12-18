package com.gusi.demo.message;

/**
 * 菜单事件消息
 *
 */
public class MenuMessage extends BaseMessage {
	private String EventKey;

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}
}