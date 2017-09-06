package com.zhibolg.zhibo.entity;


import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;

import com.zhibolg.base.EntityBase;

public class User extends EntityBase<User>{
	
	private String userName;
	private String userPwd;
	private String email;
	private int power;
	
	public User() {
		super();
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
		this.userPwd = DigestUtils.md5Hex(userPwd); 
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
		this.power = power;
	}

	@Override
	public String toString() {
		return "User [id=" + super.getId() + ",userName=" + userName + ", userPwd=" + userPwd + ", email=" + email
				+ ", power=" + power + ", delFlag=" + super.getDelFlag() + "]";
	}

}


