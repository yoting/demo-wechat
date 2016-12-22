package com.gusi.demo.mng.model.menu;

import java.util.Arrays;

import com.alibaba.fastjson.JSONObject;

public class MenuSpecial extends Menu {
	private Matchrule matchrule;

	public Matchrule getMatchrule() {
		return matchrule;
	}

	public void setMatchrule(Matchrule matchrule) {
		this.matchrule = matchrule;
	}

	@Override
	public String toString() {
		return "MenuSpecial [matchrule=" + matchrule + ", button=" + Arrays.toString(button) + "]";
	}

	public static String getDemoMenuSpecial() {
		MenuSpecial menu = new MenuSpecial();

		ClickButton clickButton = new ClickButton();
		clickButton.setName("click菜单s");
		clickButton.setType(CLICK);
		clickButton.setKey("11");

		ViewButton viewButton = new ViewButton();
		viewButton.setName("view菜单s");
		viewButton.setType(VIEW);
		viewButton
				.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx2d55a802cd62c6ad&redirect_uri=http://yoting.tunnel.qydev.com/business&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirect");

		ClickButton comp1Button = new ClickButton();
		comp1Button.setKey("31");
		comp1Button.setName("扫描事件");
		comp1Button.setType(SCANCODE_PUSH);
		ClickButton comp2Button = new ClickButton();
		comp2Button.setKey("32");
		comp2Button.setName("定位事件");
		comp2Button.setType(LOCATION_SELECT);

		Button compButton = new Button();
		compButton.setName("复合菜单s");
		compButton.setSub_button(new Button[] { comp1Button, comp2Button });

		menu.setButton(new Button[] { clickButton, viewButton, compButton });

		Matchrule matchrule = new Matchrule();
		matchrule.setSex(1);

		menu.setMatchrule(matchrule);

		String json = JSONObject.toJSONString(menu);
		// System.out.println(json);
		return json;
	}

	public static void main(String[] args) {
		String json = getDemoMenuSpecial();
		System.out.println(json);
	}

}
