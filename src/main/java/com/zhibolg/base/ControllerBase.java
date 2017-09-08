package com.zhibolg.base;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.zhibolg.zhibo.controller.UserController;
import com.zhibolg.zhibo.entity.User;
/**
* @author 罗广 
* @version 创建时间：2017年9月6日 下午8:23:50
* 类说明
*/
public class ControllerBase{

	/*
	 * 获取用户
	 */
	protected User getSessionUser(HttpServletRequest request){
		User user = (User)request.getSession().getAttribute("User_session");
		return user;
	}
	
	/*
	 * 设置用户
	 */
	protected void setSessionUser(HttpServletRequest request,User user){
		request.getSession().setAttribute("User_session", user);
		request.getSession().setAttribute("userId", user.getId());
	}
	
	/*
	 * 注销用户
	 */
	protected void logoutSessionUser(HttpServletRequest request){
		request.getSession().removeAttribute("User_session");
	}
	
	/*
	 * 获取用户ID
	 */
	protected String getSessionUserId(HttpServletRequest request){
		String id = (String)request.getSession().getAttribute("userId");
		return id;
	}
	
	
}
