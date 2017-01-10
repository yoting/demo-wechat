package com.gusi.demo.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * http请求客户端
 * 
 * @author dyy_gusi
 * @date 2016年12月29日下午5:52:22
 *
 */
public class HttpClientJDKUtil {
	public static String executeGet(String urlStr) {
		try {
			URL url = new URL(urlStr);
			URLConnection connection = url.openConnection();// 得到一个连接对象
			InputStream is = connection.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "UTF-8");
			BufferedReader br = new BufferedReader(isr);// 用于读取返回的数据流
			StringBuffer sb = new StringBuffer();// 用于接收返回的数据
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			br.close();// 关闭各种连接
			isr.close();
			is.close();

			System.out.println(sb.toString());
			return sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static String executePost(String urlStr, String params) {
		try {
			URL url = new URL(urlStr);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();// 得到一个http的连接对象
			connection.addRequestProperty("encoding", "UTF-8");
			connection.setRequestMethod("POST");// 设置请求方式
			connection.setDoInput(true);// 设置可写入
			connection.setDoOutput(true);// 设置可读取
			OutputStream os = connection.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);// 定义写入流对象
			bw.write(params);
			bw.flush();// 通过写入流对象写入请求参数
			InputStream is = connection.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "UTF-8");
			BufferedReader br = new BufferedReader(isr);// 定义读取流对象
			StringBuffer sb = new StringBuffer();
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}// 通过读取流读取返回数据

			// 关闭各种连接对象
			br.close();
			isr.close();
			is.close();
			bw.close();
			osw.close();
			os.close();

			System.out.println(sb.toString());
			return sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 请求响应后回调接口
	 * 
	 * @author dyy_gusi
	 * @date 2016年12月29日下午5:45:38
	 *
	 */
	public interface ResponseCallback {
		/**
		 * 响应后回调方法
		 *
		 * @param resultCode
		 *            响应结果码，比如200成功，404不存在，500服务器异常等
		 * @param resultJson
		 *            响应内容，目前支持JSON字符串
		 */
		void onResponse(int resultCode, String resultJson);
	}
}
