package com.zhibolg.zhibo.controller;

import static org.junit.Assert.fail;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zhibolg.base.ControllerBase;
import com.zhibolg.zhibo.entity.User;
import com.zhibolg.zhibo.service.UserService;

/**
* @author 罗广 
* @version 创建时间：2017年8月20日 下午3:28:15
* 类说明
*/
@Controller
@RequestMapping(value = "user")
public class UserController extends ControllerBase{
	private  Log log = LogFactory.getLog(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@ModelAttribute
	public User get(@RequestParam(required = false) String id){
		User user = new User();
		user.setId(id);
		if(id == null){
			return user;
		}
		return userService.get(user);
	}
	
	@RequestMapping(value = "save")
	public String save(User user,@RequestParam(required=false) String gameId){
		
		user.setUserPwd(DigestUtils.md5Hex(user.getUserPwd()));
		userService.insert(user);
		return "redirect:/ZhiBo.html?index="+gameId;  
	}
	
	/**
	 * 修改密码
	 * @param user
	 * @param passWordold 旧密码
	 * @param changepassWord 新密码
	 * @return
	 */
	@RequestMapping(value = "update")
	public String update(User user,@RequestParam(required = false) String passWordold,
			@RequestParam(required = false) String changepassWord){
		
		String pwMD5 = DigestUtils.md5Hex(passWordold);
		if(user.getUserPwd().equals(pwMD5)) {
			user.setUserPwd(DigestUtils.md5Hex(changepassWord));
			userService.update(user);
			return "redirect:/ZhiBo.html";  
		}
		return "redirect:/error/passwordError.html";
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
		return u == null ? "false" : "true";
	}
	
	/*
	 * 用户名登陆
	 */
	@RequestMapping(value = "loginUser")
	@ResponseBody
	public String loginUser(User user,HttpServletRequest request){

		user.setUserPwd(DigestUtils.md5Hex(user.getUserPwd()));
		User u = userService.loginYZ(user);
		boolean flag = u == null ? false : true;
		if (flag) {
			log.info("用户登陆："+u);
			setSessionUser(request, u);
		}
		return flag ? "true" : "false";
	}
	
	
	/*
	 * 用户注销
	 */
	@RequestMapping(value = "logoutUser")
	public String logoutUser(HttpServletRequest request){
		logoutSessionUser(request);
		return "redirect:/ZhiBo.html"; 
	}
	
}


