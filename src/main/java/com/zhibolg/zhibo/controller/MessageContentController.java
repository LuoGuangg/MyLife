package com.zhibolg.zhibo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zhibolg.base.ControllerBase;
import com.zhibolg.zhibo.entity.MessageContent;
import com.zhibolg.zhibo.entity.User;
import com.zhibolg.zhibo.service.MessageContentService;
import com.zhibolg.zhibo.service.UserService;

/**
* @author 罗广 
* @version 创建时间：2017年9月7日 下午11:34:32
* 类说明
*/
@Controller
@RequestMapping(value = "message/content")
public class MessageContentController  extends ControllerBase{
	
	@Autowired
	private MessageContentService messageContService;
	
	@ModelAttribute
	public MessageContent get(@RequestParam(required = false) String id){
		if(id == null){
			return new MessageContent();
		}
		return messageContService.get(id);
	}
	
	@RequestMapping(value = "save")
	public String save(MessageContent messageContent){
		messageContService.insert(messageContent);
		return "redirect:/ZhiBo.html";  
	}

	@RequestMapping(value = "update")
	public void update(MessageContent messageContent){
		messageContService.update(messageContent);
	}

	@RequestMapping(value = "delete")
	public void delete(MessageContent messageContent){
		messageContService.delete(messageContent);
	}
	
	
}
