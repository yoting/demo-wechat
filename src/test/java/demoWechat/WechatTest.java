package demoWechat;

import org.junit.Test;

import com.gusi.demo.thrid.wechat.WechatAPI;
import com.gusi.demo.utils.SpringBeanUtil;

public class WechatTest {

	@Test
	public void testEV() {
		Object o = SpringBeanUtil.getBean("wechatController");
		System.out.println(o);
	}

	@Test
	public void testCreateMenu() {
		WechatAPI.createMenu(null, null);
	}
}
