package com.zhibolg.admin.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhibolg.base.ControllerBase;

/**
* @author 罗广 
* @version 创建时间：2017年9月10日 下午11:24:08
* 类说明
*/
@Controller
@RequestMapping(value = "error")
public class ErrorController extends ControllerBase{

	private Log log = LogFactory.getLog(ErrorController.class);
	
	@RequestMapping(value = "")
	public String error(){
		log.info("错误");
		return "error/error";
	}
}
