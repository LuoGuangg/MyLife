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
	
	
	/**
	 * 获取访问IP
	 * @param request
	 * @return 访问的IP
	 * @throws Exception
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
	
	/**
	 * 根据IP获取地理位置
	 * @param vistIp 需要获取地理位置的IP
	 * @return 返回VistIp
	 */
	public static VistIp getAddressByIP(VistIp vistIp) {
		try {
			
			//调用taobao的接口，传递一个IP过去。将会返回IP地理位置的JSON信息
			URL url = new URL("http://ip.taobao.com/service/getIpInfo.php?ip=" + vistIp.getIp());
			URLConnection conn = url.openConnection();
			conn.setReadTimeout(500);
			
			//获取taobao接口返回的信息
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "GBK"));
			String line = null;
			StringBuffer result = new StringBuffer();
			while ((line = reader.readLine()) != null) {
				result.append(line);
			}
			reader.close();
			
			//解析JSON信息
			JSONObject jsonObject = JSONObject.fromObject(result.toString());
			
			//code == 0表示获取IP地理位置信息成功
			int code = (Integer) jsonObject.get("code");	
			
			if(code == 0){
				JSONObject json = (JSONObject) jsonObject.get("data");
				
				//获取IP所在的国家
				String  country = (String) json.get("country");
				
				//获取IP所在的城市
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
