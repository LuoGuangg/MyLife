package com.zhibolg.admin.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhibolg.admin.dao.VistIpDao;
import com.zhibolg.admin.entity.VistIp;
import com.zhibolg.base.DaoBase;
import com.zhibolg.base.ServiceBase;
import com.zhibolg.zhibo.entity.User;

/**
* @author 罗广 
* @version 创建时间：2017年9月11日 下午5:10:53
* 类说明
*/
@Service
public class VistIpService extends  ServiceBase<DaoBase<VistIp>, VistIp>{
	
	@Autowired
	private VistIpDao dao;
	
	public VistIp getByDay(VistIp vistIp){
		vistIp.setCreateDate(new Date());
		return dao.getByDay(vistIp);
	}
}
