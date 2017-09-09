package com.zhibolg.zhibo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhibolg.base.DaoBase;
import com.zhibolg.base.ServiceBase;
import com.zhibolg.zhibo.dao.MessageAllDao;
import com.zhibolg.zhibo.entity.MessageAll;

/**
* @author 罗广 
* @version 创建时间：2017年9月8日 下午8:21:46
* 类说明
*/
@Service
public class MessageAllService  extends ServiceBase<DaoBase<MessageAll>, MessageAll>{
	
	@Autowired
	private MessageAllDao dao;
	
	public List<MessageAll> findListHuiFuByContentId(String contentId){
		return dao.findListHuiFuByContentId(contentId);
	}
}
