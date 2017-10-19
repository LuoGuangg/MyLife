package com.zhibolg.admin.entity;

import java.util.HashMap;
import java.util.Map;

import com.zhibolg.base.EntityBase;

/**
* @author 罗广 
* @version 创建时间：2017年9月11日 下午5:08:32
* 类说明
*/
public class VistIp extends EntityBase<VistIp>{
	
	private String ip;	//ip地址
	private String country;	//国家
	private String city;	//城市
	
	private String num; //访问数
	
	private Map<String, String> pageMap = new HashMap<String, String>();
	
	public VistIp() {
		super();
	}
	
	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public VistIp(String ip, String country, String city) {
		super();
		this.ip = ip;
		this.country = country;
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public Map<String, String> getPageMap() {
		return pageMap;
	}

	public void setPageMap(Map<String, String> pageMap) {
		this.pageMap = pageMap;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public VistIp(String ip) {
		this.ip = ip;
	}
	
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Override
	public String toString() {
		return "VistIp [ip=" + ip + ", country=" + country + ", city=" + city + "]";
	}
	
	
}
