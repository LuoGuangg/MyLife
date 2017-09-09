package com.zhibolg.zhibo.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhibolg.base.ControllerBase;
import com.zhibolg.zhibo.entity.MessageAll;
import com.zhibolg.zhibo.entity.MessageContent;
import com.zhibolg.zhibo.service.MessageAllService;
import com.zhibolg.zhibo.service.MessageContentService;

/**
* @author 罗广 
* @version 创建时间：2017年9月9日 下午3:04:46
* 类说明
*/
@Controller
@RequestMapping(value = "message/all")
public class MessageAllController  extends ControllerBase{

	private Log log = LogFactory.getLog(MessageAllController.class);
	
	@Autowired
	private MessageContentService messageContService;
	
	@Autowired
	private MessageAllService messageAllService;
	
	@ModelAttribute
	public MessageAll get(@RequestParam(required = false) String id){
		
		MessageAll messageAll = new MessageAll();
		messageAll.setId(id);
		
		if(id == null){
			return messageAll;
		}
		
		return messageAllService.get(messageAll);
	}
	

	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(MessageAll messageAll){
		try {
			messageAllService.delete(messageAll);
			
			/*
			 * 删除留言内容
			 */
			MessageContent mContent = new MessageContent();
			mContent.setId(messageAll.getContentId());
			messageContService.delete(mContent);
			/*
			 * 删除留言下回复内容
			 */
			mContent.setId(messageAll.getTargetId());
			messageContService.delete(mContent);
			
			
			} catch (Exception e) {
				log.error("未知错误:"+e);
				return "false";
		}
		return "true";
	}
	

	@RequestMapping(value = "deletePingLun")
	@ResponseBody
	public String deletePingLun(MessageAll messageAll){
		try {
			messageAllService.delete(messageAll);
			
			/*
			 * 删除留言内容
			 */
			MessageContent mContent = new MessageContent();
			mContent.setId(messageAll.getContentId());
			messageContService.delete(mContent);
			
			} catch (Exception e) {
				log.error("未知错误:"+e);
				return "false";
		}
		return "true";
	}
}
