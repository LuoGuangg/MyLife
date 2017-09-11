package com.zhibolg.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author 罗广
 * @version 创建时间：2017年9月11日 下午7:41:31 类说明
 */
public class IpTest {
	public static final String JSON_MULTI = "{'name':'tom','score':{'Math':98,'English':90}}";
	 
	public static void main(String[] args) {
		getAddressByIP();
		
	}
	public static void getAddressByIP() {
		try {
			String strIP = "110.53.191.43";
			URL url = new URL("http://ip.taobao.com/service/getIpInfo.php?ip=" + strIP);
			URLConnection conn = url.openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "GBK"));
			String line = null;
			StringBuffer result = new StringBuffer();
			while ((line = reader.readLine()) != null) {
				result.append(line);
			}
			System.out.println(result.toString());
			JSONObject jsonObject = JSONObject.fromObject(result.toString());
			System.out.println(jsonObject.get("code"));
			
			JSONObject json = (JSONObject) jsonObject.get("data");
			System.out.println(json.get("country"));
			System.out.println(json.get("city"));
			
			
			reader.close();
		} catch (IOException e) {
		}
	}
}
