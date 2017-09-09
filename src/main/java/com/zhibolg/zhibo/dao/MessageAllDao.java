package com.zhibolg.zhibo.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.zhibolg.base.DaoBase;
import com.zhibolg.zhibo.entity.MessageAll;
import com.zhibolg.zhibo.entity.MessageContent;

/**
* @author 罗广 
* @version 创建时间：2017年9月8日 下午8:21:06
* 类说明
*/
@Component
public interface MessageAllDao  extends DaoBase<MessageAll>{

	/*
	 * 通过targetId 获取回复
	 */
	List<MessageAll> findListHuiFuByContentId(String contentId);
	
}
