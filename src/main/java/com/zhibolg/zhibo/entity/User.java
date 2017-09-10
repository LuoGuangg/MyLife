package com.zhibolg.zhibo.entity;



import org.apache.commons.codec.digest.DigestUtils;

import com.zhibolg.base.EntityBase;

public class User extends EntityBase<User>{
	
	private String userName;
	private String userPwd;
	private String email;
	private int power;	//权限 0：普通用户 1：管理员
	
	private String powerString; //权限内容
	
	public User() {
		super();
	}
	
	public User(String id) {
		super(id);
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


