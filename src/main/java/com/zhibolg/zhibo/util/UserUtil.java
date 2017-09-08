package com.zhibolg.zhibo.util;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.zhibolg.zhibo.entity.User;
import com.zhibolg.zhibo.service.UserService;

/**
* @author 罗广 
* @version 创建时间：2017年9月8日 上午9:37:57
* 类说明
*/
public class UserUtil {
	private static ApplicationContext ac = new ClassPathXmlApplicationContext("spring-Service.xml");//第1行
    
	public static User getUser(){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		String userId = (String)request.getSession().getAttribute("userId");
		UserService userService = (UserService)ac.getBean("userService");
		User user = new User();
		user.setId(userId);
		return userService.get(user);
	}
}
