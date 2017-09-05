package com.zhibolg.zhibo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zhibolg.zhibo.entity.User;
import com.zhibolg.zhibo.service.UserService;

/**
* @author 罗广 
* @version 创建时间：2017年8月20日 下午3:28:15
* 类说明
*/
@Controller
@RequestMapping(value = "user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@ModelAttribute
	public User get(@RequestParam(required = false) String id){
		if(id == null){
			return new User();
		}
		return userService.get(id);
	}
	
	@RequestMapping(value = "")
	public void list(User user){
	}
	
	@RequestMapping(value = "save")
	public String save(User user){
		userService.insert(user);
		
		return "redirect:/ZhiBo.html";  
	}

	@RequestMapping(value = "update")
	public void update(User user){
		userService.update(user);
	}

	@RequestMapping(value = "delete")
	public void delete(User user){
		userService.delete(user);
	}
	
	/*
	 * 异步验证用户名是否已存在
	 */
	@RequestMapping(value = "verifyUserName")
	@ResponseBody
	public String verifyUserName(@RequestParam("userName") String userName){
		User user = new User();
		user.setUserName(userName);
		User u = userService.get(user);
		return u==null ? "false" : "true";
	}
	
}


