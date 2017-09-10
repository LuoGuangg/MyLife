package com.zhibolg.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zhibolg.zhibo.controller.UserController;
import com.zhibolg.zhibo.entity.User;
import com.zhibolg.zhibo.util.UserUtil;

/**
* @author 罗广 
* @version 创建时间：2017年9月10日 下午10:46:35
* 类说明 登陆拦截器
*/
@Repository
public class LoginInterceptor implements HandlerInterceptor{
	
	private Log log = LogFactory.getLog(LoginInterceptor.class);
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, 
			Object arg2, Exception arg3)
			throws Exception {
		log.info("afterCompletion");
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
			ModelAndView arg3)
			throws Exception {
		log.info("postHandle");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		 //获取url地址  
		boolean flag = true;
        String reqUrl=request.getRequestURI().replace(request.getContextPath(), ""); 
        
        if(reqUrl.contains("admin")){
        	
        	User user =  UserUtil.getUser();
        	if(user != null && user.getPower() == 1){
        		flag = true;
        	}else {
            	flag = false;
            	response.sendRedirect("error.html");
        	}
        	
        }
		return flag;
	}

}
