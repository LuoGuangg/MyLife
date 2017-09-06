package com.zhibolg.zhibo.dao;

import org.springframework.stereotype.Component;

import com.zhibolg.base.DaoBase;
import com.zhibolg.zhibo.entity.User;

@Component
public interface UserDao extends DaoBase<User>{

	/*
	 * 验证用户名登陆信息
	 */
	public User loginYZ(User user);
	
}
