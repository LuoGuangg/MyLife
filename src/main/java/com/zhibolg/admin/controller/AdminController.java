package com.zhibolg.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.tomcat.util.log.UserDataHelper.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zhibolg.admin.entity.VistIp;
import com.zhibolg.admin.service.VistIpService;
import com.zhibolg.base.ControllerBase;
import com.zhibolg.zhibo.controller.UserController;
import com.zhibolg.zhibo.entity.Page;
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
	@Autowired
	private VistIpService vistIpService;
	
	@RequestMapping(value = "")
	public String admin(Model model, 
			@RequestParam(required = false) String pageNo,
			@RequestParam(required = false) String pageSize,
			@RequestParam(required = false) String userName){
		model.addAttribute("user", UserUtil.getUser());
		
		/*
		 * 获得所有用户信息
		 */
		User user = new User();
		user.setUserName(userName);
		user.getPageMap().put("userName", userName);
		log.info(user);
		model.addAttribute("userFrom", user);
		

		Page<User> upage = new Page<>(null, pageNo, pageSize);
		upage.setPageSize(2);
		upage.getPageMap().put("userName", userName);
		
	 	Page<User> page = userService.findPage(upage, user);
		model.addAttribute("page", page);
		
		return "admin/admin";
	}
	
	
	@RequestMapping(value = "ip")
	public String ip(Model model){
		model.addAttribute("user", UserUtil.getUser());
		
		/*
		 * 获得所有IP
		 */
		VistIp vistIp = new VistIp();
		List<VistIp> vistIpList = vistIpService.findList(vistIp);
		model.addAttribute("vistIpList", vistIpList);
		
		return "admin/ip";
	}
}
