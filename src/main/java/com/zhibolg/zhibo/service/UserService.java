package com.zhibolg.zhibo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhibolg.base.DaoBase;
import com.zhibolg.base.ServiceBase;
import com.zhibolg.zhibo.dao.UserDao;
import com.zhibolg.zhibo.entity.User;

/**
* @author 罗广 
* @version 创建时间：2017年8月20日 下午3:14:36
* 类说明
*/
@Service
public class UserService extends ServiceBase<DaoBase<User>, User>{
	
	@Autowired
	private UserDao dao;
	
	public User loginYZ(User user){
		return dao.loginYZ(user);
	}
}
