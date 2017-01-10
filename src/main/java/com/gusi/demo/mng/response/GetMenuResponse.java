package com.gusi.demo.mng.response;

import com.gusi.demo.mng.model.menu.Menu;

/**
 * @author peiyu
 */
public class GetMenuResponse extends BaseResponse {

	private Menu menu;

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
}
