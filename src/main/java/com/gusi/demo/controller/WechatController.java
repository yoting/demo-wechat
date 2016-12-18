package com.gusi.demo.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gusi.demo.message.TextMessage;
import com.gusi.demo.utils.MessageUtil;
import com.gusi.demo.utils.WechatSignUtil;

@RestController
@RequestMapping("/wechat")
public class WechatController {

	@RequestMapping(value = "", method = RequestMethod.GET, produces = "text/plain;charset=utf-8")
	public String verify(@RequestParam("signature") String signature,
			@RequestParam("timestamp") String timestamp,
			@RequestParam("nonce") String nonce,
			@RequestParam("echostr") String echostr) {
		// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
		if (WechatSignUtil.checkSignature(signature, timestamp, nonce)) {
			return echostr;
		}
		return "";
	}

	// 调用核心业务类接收消息、处理消息跟推送消息，这里暂时不做处理
	@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/xml; charset=UTF-8")
	public String post(HttpServletRequest req) {

		try {
			Map<String, String> reqMap = MessageUtil.parseXml(req);

			String MsgId = reqMap.get("MsgId");
			String MsgType = reqMap.get("MsgType");
			String FromUserName = reqMap.get("FromUserName");
			String ToUserName = reqMap.get("ToUserName");

			for (Map.Entry<String, String> p : reqMap.entrySet()) {
				System.out.println(p.getKey() + ":" + p.getValue());
			}
			if (MessageUtil.REQ_MESSAGE_TYPE_TEXT.equals(MsgType)) {
				TextMessage message = new TextMessage();
				String Content = reqMap.get("Content");
				if ("1".equals(Content)) {
					message.setContent("感谢回复，您的消息内容是：" + "第一类消息");
				} else if ("2".equals(Content)) {
					message.setContent("感谢回复，您的消息内容是：" + "第二类消息");
				} else {
					message.setContent("感谢回复，您的消息内容我不能帮你获取！");
				}
				message.setFromUserName(ToUserName);
				message.setToUserName(FromUserName);
				message.setCreateTime(System.currentTimeMillis());

				String result = MessageUtil.parseTextMessageToXml(message);
				// System.out.println(result);
				return result;
			} else if (MessageUtil.REQ_MESSAGE_TYPE_EVENT.equals(MsgType)) {
				String Event = reqMap.get("Event");
				if (Event.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
					System.out.println("取消了关注！");
				} else if (Event.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
					TextMessage message = new TextMessage();
					message.setContent("感谢关注，请回复以下数字获取内容信息！/r/n1、获取第一个信息/r/n2、获取第二个信息");
					message.setFromUserName(ToUserName);
					message.setToUserName(FromUserName);
					message.setCreateTime(System.currentTimeMillis());
					return MessageUtil.parseTextMessageToXml(message);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
