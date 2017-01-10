package com.gusi.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gusi.demo.message.Article;
import com.gusi.demo.message.NewsMessage;
import com.gusi.demo.message.TextMessage;
import com.gusi.demo.mng.WechatTokenMng;
import com.gusi.demo.mng.WechatUserInfoMng;
import com.gusi.demo.mng.WechatUserInfoMng.UserInfo;
import com.gusi.demo.utils.MessageUtil;
import com.gusi.demo.utils.WechatSignUtil;

@RestController
@RequestMapping("/wechat")
public class WechatController {

	/**
	 * 微信接口绑定
	 * 
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @param echostr
	 * @return
	 */
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "text/plain;charset=utf-8")
	public String bound(@RequestParam("signature") String signature, @RequestParam("timestamp") String timestamp,
			@RequestParam("nonce") String nonce, @RequestParam("echostr") String echostr) {
		// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
		if (WechatSignUtil.checkSignature(signature, timestamp, nonce)) {
			return echostr;
		}
		return "";
	}

	/**
	 * 调用核心业务类接收消息、处理消息跟推送消息
	 * 
	 * @param req
	 * @return
	 */
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
			System.out.println("-------------------------------------");
			if (MessageUtil.REQ_MESSAGE_TYPE_TEXT.equals(MsgType)) {
				String result = null;
				String Content = reqMap.get("Content");

				if ("1".equals(Content)) {
					TextMessage message = new TextMessage();
					message.setContent("感谢回复，您的消息内容是：" + "第一类消息");
					message.setFromUserName(ToUserName);
					message.setToUserName(FromUserName);
					message.setCreateTime(System.currentTimeMillis());
					result = MessageUtil.parseTextMessageToXml(message);
				} else if ("2".equals(Content)) {
					TextMessage message = new TextMessage();
					message.setContent("感谢回复，您的消息内容是：" + "第二类消息");
					message.setFromUserName(ToUserName);
					message.setToUserName(FromUserName);
					message.setCreateTime(System.currentTimeMillis());
					result = MessageUtil.parseTextMessageToXml(message);
				} else if ("3".equals(Content)) {
					NewsMessage message = new NewsMessage();
					message.setFromUserName(ToUserName);
					message.setToUserName(FromUserName);
					message.setCreateTime(System.currentTimeMillis());
					List<Article> articles = new ArrayList<Article>();
					Article article = new Article();
					article.setTitle("消息标题");
					article.setDescription("消息描述");
					article.setUrl("http://yoting.github.io");
					article.setPicUrl("http://yoting.tunnel.qydev.com/images/bg.jpg");
					articles.add(article);
					message.setArticles(articles);
					message.setArticleCount(articles.size());

					result = MessageUtil.parseNewsMessageToXml(message);
				} else if ("4".equals(Content)) {
					NewsMessage message = new NewsMessage();
					message.setFromUserName(ToUserName);
					message.setToUserName(FromUserName);
					message.setCreateTime(System.currentTimeMillis());
					List<Article> articles = new ArrayList<Article>();
					Article article1 = new Article();
					article1.setTitle("消息标题一");
					article1.setDescription("消息描述一");
					article1.setUrl("http://yoting.github.io");
					article1.setPicUrl("http://yoting.tunnel.qydev.com/images/bg.jpg");
					articles.add(article1);
					Article article2 = new Article();
					article2.setTitle("消息标题二");
					article2.setDescription("消息描述二");
					article2.setUrl("http://yoting.github.io");
					article2.setPicUrl("http://yoting.tunnel.qydev.com/images/bg.jpg");
					articles.add(article2);
					message.setArticles(articles);
					message.setArticleCount(articles.size());

					result = MessageUtil.parseNewsMessageToXml(message);
				} else {
					TextMessage message = new TextMessage();
					message.setContent("感谢回复，您的消息内容我不能帮你获取！");
					message.setFromUserName(ToUserName);
					message.setToUserName(FromUserName);
					message.setCreateTime(System.currentTimeMillis());
					result = MessageUtil.parseTextMessageToXml(message);
				}

				// System.out.println(result);
				return result;
			} else if (MessageUtil.REQ_MESSAGE_TYPE_EVENT.equals(MsgType)) {
				String Event = reqMap.get("Event");
				if (Event.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
					System.out.println("取消了关注！");
				} else if (Event.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
					TextMessage message = new TextMessage();

					UserInfo userinfo = WechatUserInfoMng.getUserInfoByFouse(WechatTokenMng.getAccessToken().getToken(), FromUserName);

					message.setContent("感谢关注，" + userinfo.toString()
							+ "\r\n请回复以下数字获取内容信息！\r\n1、获取第一个信息\r\n2、获取第二个信息\r\n3、获取一个新闻消息\r\n4、获取多个新闻消息");
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
