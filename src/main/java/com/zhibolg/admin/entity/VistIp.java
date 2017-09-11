package com.zhibolg.admin.entity;

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
	
	public VistIp() {
		super();
	}
	
	public String getCountry() {
		return country;
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
