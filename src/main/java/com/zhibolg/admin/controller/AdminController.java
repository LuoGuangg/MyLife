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
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhibolg.admin.entity.Ma;
import com.zhibolg.admin.entity.VistIp;
import com.zhibolg.admin.service.MaService;
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
	
	@Autowired
	private MaService maService;
	
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
		model.addAttribute("userFrom", user);
		

		Page<User> upage = new Page<User>(null, pageNo, pageSize);
		upage.getPageMap().put("userName", userName);
		
	 	Page<User> page = userService.findPage(upage, user);
		model.addAttribute("page", page);
		
		return "admin/admin";
	}
	
	
	@RequestMapping(value = "ip")
	public String ip(Model model, 
			@RequestParam(required = false) String pageNo,
			@RequestParam(required = false) String pageSize,
			@RequestParam(required = false) String ip,
			@RequestParam(required = false) String country,
			@RequestParam(required = false) String city){
		model.addAttribute("user", UserUtil.getUser());
		
		/*
		 * 获得所有IP
		 */
		
		VistIp vistIp = new VistIp(ip, country, city);
		vistIp.getPageMap().put("ip", ip);
		vistIp.getPageMap().put("country", country);
		vistIp.getPageMap().put("city", city);
		model.addAttribute("vistIpFrom", vistIp);
		

		Page<VistIp> upage = new Page<VistIp>(null, pageNo, pageSize);
		upage.getPageMap().put("ip", ip);
		upage.getPageMap().put("country", country);
		upage.getPageMap().put("city", city);
		
	 	Page<VistIp> page = vistIpService.findPage(upage, vistIp);
		model.addAttribute("page", page);
		
		return "admin/ip";
	}
	
	@RequestMapping(value = "black")
	@ResponseBody
	public String black(@RequestParam("id") String id){
		
		User u = new User();
		u.setId(id);
		
		User user = userService.get(u);
		
		int black = user.getBlack() == 1 ? 0 : 1;
		
		user.setBlack(black);
		userService.update(user);
		
		return "";
	}
	
	/*
	 * 关于赌马
	 */
	

	@RequestMapping(value = "addDuMa")
	public String addDuMa(Model model,@RequestParam(required = false) String maName1,
			@RequestParam(required = false) String maColor1,
			@RequestParam(required = false) String maName2,
			@RequestParam(required = false) String maColor2,
			@RequestParam(required = false) String maWin,
			@RequestParam(required = false) String maNameSearch,
			@RequestParam(required = false) String maColorSearch,
			@RequestParam(required = false) String maNameSearch2,
			@RequestParam(required = false) String maColorSearch2){
		
		model.addAttribute("user", UserUtil.getUser());
		if(maName1 != null) {
			Ma ma1 = new Ma();
			ma1.setMaType(maName1+"-->"+maColor1);
			ma1.setMaType2(maName2+"-->"+maColor2);
			
			if("前者".equals(maWin)) {
				ma1.setMaWin(ma1.getMaType());
			}else {
				ma1.setMaWin(ma1.getMaType2());
			}
			
			maService.insert(ma1);
			
		}
		Ma ma = new Ma();
		if(maNameSearch != null && maNameSearch != "") {
			ma.setMaType(maNameSearch+"%"+maColorSearch);
		}
		
		if(maNameSearch2 != null && maNameSearch2 != "") {
			ma.setMaType2(maNameSearch2+"%"+maColorSearch2);
		}
		
		List<Ma> maList = maService.findList(ma);
		model.addAttribute("maList", maList);
		
		return "admin/duma/addDuMa";
	}
	
}

