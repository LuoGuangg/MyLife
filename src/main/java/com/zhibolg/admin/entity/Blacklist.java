package com.zhibolg.admin.entity;

import com.zhibolg.base.EntityBase;

/**
* @author 罗广 
* @version 创建时间：2017年9月15日 下午11:15:56
* 类说明 黑名单
*/
public class Blacklist extends EntityBase<Blacklist>{
	
	private String userName;	//用户名
	private String ip;			//IP
	private int time;			//拉黑时间/分钟
	
	public Blacklist() {
		super();
	}
	
	public Blacklist(String userName, String ip, int time) {
		super();
		this.userName = userName;
		this.ip = ip;
		this.time = time;
	}

	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Blacklist [userName=" + userName + ", ip=" + ip + ", time=" + time + "]";
	}
	
	
}
