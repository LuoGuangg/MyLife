package com.zhibolg.zhibo.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.zhibolg.admin.entity.VistIp;

import net.sf.json.JSONObject;

/**
 * @author 罗广
 * @version 创建时间：2017年9月11日 下午4:58:30 类说明
 */
public class IpUtil {
	
	/*
	 * 获取访问IP
	 */
	public static String getIpAddr(HttpServletRequest request) throws Exception {
		String ip = request.getHeader("X-Real-IP");
		if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
			return ip;
		}
		ip = request.getHeader("X-Forwarded-For");
		if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
			int index = ip.indexOf(',');
			if (index != -1) {
				return ip.substring(0, index);
			} else {
				return ip;
			}
		} else {
			return request.getRemoteAddr();
		}
	}
	/*
	 * 根据IP获取地理位置
	 */
	public static VistIp getAddressByIP(VistIp vistIp) {
		try {
			URL url = new URL("http://ip.taobao.com/service/getIpInfo.php?ip=" + vistIp.getIp());
			URLConnection conn = url.openConnection();
			conn.setReadTimeout(500);
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "GBK"));
			String line = null;
			StringBuffer result = new StringBuffer();
			while ((line = reader.readLine()) != null) {
				result.append(line);
			}
			reader.close();
			
			JSONObject jsonObject = JSONObject.fromObject(result.toString());
			
			int code = (int) jsonObject.get("code");	
			
			if(code == 0){
				JSONObject json = (JSONObject) jsonObject.get("data");
				String  country = (String) json.get("country");
				String  city = (String) json.get("city");
				
				vistIp.setCountry(country);
				vistIp.setCity(city);
			}
			
		} catch (IOException e) {
			
			return vistIp;
		}
		
		return vistIp;
	}
}
