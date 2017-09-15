package com.zhibolg.base;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.zhibolg.Interceptor.LoginInterceptor;
import com.zhibolg.zhibo.entity.Page;
import com.zhibolg.zhibo.entity.User;
import com.zhibolg.zhibo.service.UserService;
import com.zhibolg.zhibo.util.UserUtil;


public abstract class ServiceBase<D extends DaoBase<T>,T extends EntityBase<T>>{
	
	private Log log = LogFactory.getLog(ServiceBase.class);
	
	@Autowired
	protected D dao;
	
	
	public List<T> findList(T entity){
		return dao.findList(entity);
	}
	
	public T get(T entity){
		return dao.get(entity);
	}

	public T get(String id){
		return dao.get(id);
	}
	
	public Page<T> findPage(Page<T> page,T entity){
		entity.setPage(page);
		page.setResults(dao.findList(entity));
		
		return page;
	}
	
	public int insert(T entity){
		User user = UserUtil.getUser();
		Date d = new Date(System.currentTimeMillis());
		entity.setCreateDate(d);
		entity.setUpdateDate(d);
		entity.setCreateBy(user);
		entity.setUpdateBy(user);
		
		entity.setId(UUID.randomUUID().toString().replace("-", ""));
		
		return dao.insert(entity);
	}
	
	public int update(T entity){
		User user = UserUtil.getUser();
		entity.setUpdateBy(user);
		
		Date d = new Date(System.currentTimeMillis());
		entity.setUpdateDate(d);
		
		return dao.update(entity);
	}

	public int delete(T entity){
		return dao.delete(entity);
	}
	
	
	
}
