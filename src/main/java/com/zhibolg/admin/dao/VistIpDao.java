package com.zhibolg.admin.dao;

import org.springframework.stereotype.Component;

import com.zhibolg.admin.entity.VistIp;
import com.zhibolg.base.DaoBase;

/**
* @author 罗广 
* @version 创建时间：2017年9月11日 下午5:10:016
* 类说明
*/
@Component
public interface VistIpDao extends DaoBase<VistIp>{

	/*
	 * 判断今天IP是否来过
	 */
	VistIp getByDay(VistIp vistIp);

}
