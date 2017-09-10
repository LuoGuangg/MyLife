package com.zhibolg.admin.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.tomcat.util.log.UserDataHelper.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhibolg.base.ControllerBase;
import com.zhibolg.zhibo.controller.UserController;
import com.zhibolg.zhibo.entity.User;
import com.zhibolg.zhibo.service.UserService;
import com.zhibolg.zhibo.util.UserUtil;

/**
* @author 罗广 
* @version 创建时间：2017年9月10日 下午11:00:42
* 类说明
*/
@Controller
@RequestMapping(value = "admin")
public class AdminController extends ControllerBase{
	private Log log = LogFactory.getLog(AdminController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "")
	public String admin(Model model){
	 	List<User> userlist = userService.findList(new User());
		model.addAttribute("user", UserUtil.getUser());
		model.addAttribute("userlist", userlist);
		return "admin/admin";
	}
}
