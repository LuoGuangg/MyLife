package com.zhibolg.zhibo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.zhibolg.base.ControllerBase;
import com.zhibolg.zhibo.entity.Page;
import com.zhibolg.zhibo.entity.User;
import com.zhibolg.zhibo.entity.ZhiBo;
import com.zhibolg.zhibo.service.ZhiBoService;

@Controller
@RequestMapping(value = "ZhiBo")
public class ZhiBoController extends ControllerBase{
	private static Log logger = LogFactory.getLog(UserController.class);

	@Autowired
	private ZhiBoService ZhiBoService;

	@ModelAttribute
	public Page<ZhiBo> get(@RequestParam(required = false) String index,@RequestParam(required=false) String name, HttpServletRequest request,
			HttpServletResponse response) {
		ZhiBo zhiBo = new ZhiBo();
		if(index == null) { 
			index = 1+"";
		}
		zhiBo.getPageMap().put("index", index);
		zhiBo.getPageMap().put("name", name);
		
		Page<ZhiBo> p = new Page<ZhiBo>(request, response, index);
		p.getPageMap().put("name", name);
		
		Page<ZhiBo> page = ZhiBoService.findPage(p, zhiBo);
		return page;
	}

	@RequestMapping(value = "")
	public String ZhiBo(Page<ZhiBo> page, Model model) {
		
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		User u = getSessionUser(request);
		logger.info(u);
		model.addAttribute("page", page);
		model.addAttribute("user", new User());
		return "zhibo/zhiBo";
	}
}
