package com.zhibolg.zhibo.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zhibolg.base.ControllerBase;
import com.zhibolg.zhibo.entity.MessageAll;
import com.zhibolg.zhibo.entity.MessageContent;
import com.zhibolg.zhibo.entity.User;
import com.zhibolg.zhibo.service.MessageAllService;
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
	
	private Log logger = LogFactory.getLog(MessageContentController.class);
	
	@Autowired
	private MessageContentService messageContService;
	
	@Autowired
	private MessageAllService messageAllService;
	
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
		
		MessageAll messageAll = new MessageAll();
		messageAll.setContentId(messageContent.getId());
		messageAllService.insert(messageAll);
		
		return "redirect:/ZhiBo.html?index="+messageContent.getGameId();  
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
