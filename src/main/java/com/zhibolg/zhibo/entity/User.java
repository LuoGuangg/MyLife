package com.zhibolg.zhibo.entity;



import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.zhibolg.admin.controller.AdminController;
import com.zhibolg.base.EntityBase;

public class User extends EntityBase<User>{
	private Log log = LogFactory.getLog(User.class);
	
	private String userName;
	private String userPwd;
	private String email;
	private int black;	//拉黑，禁止发言（0，正常 1，拉黑）
	private int power;	//权限 0：普通用户 1：管理员
	
	private String powerString; //权限内容

	private Map<String, String> pageMap = new HashMap<String, String>();
	
	public User() {
		super();
	}
	
	public User(String id) {
		super(id);
	}
	
	
	public int getBlack() {
		return black;
	}

	public void setBlack(int black) {
		this.black = black;
	}

	public Map<String, String> getPageMap() {
		return pageMap;
	}

	public void setPageMap(Map<String, String> pageMap) {
		this.pageMap = pageMap;
	}

	public String getPowerString() {
		return powerString;
	}

	public void setPowerString(String powerString) {
		this.powerString = powerString;
	}

	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd; 
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		String powStr = "";
		if(power == 0){
			powStr = "普通用户";
		}else if(power == 1){
			powStr = "管理员";
		}
		this.powerString = powStr;
		this.power = power;
	}

	@Override
	public String toString() {
		return "User [id=" + super.getId() + ",userName=" + userName + ", userPwd=" + userPwd + ", email=" + email
				+ ", power=" + power + ", delFlag=" + super.getDelFlag() + "]";
	}

}


