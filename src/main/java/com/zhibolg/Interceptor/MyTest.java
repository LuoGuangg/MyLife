package com.zhibolg.Interceptor;

import java.sql.Connection;
import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;

/**
* @author 罗广 
* @version 创建时间：2017年9月5日 下午3:12:05
* 类说明
*/
@Intercepts({@Signature(type = StatementHandler.class,method = "prepare", args = {Connection.class, Integer.class})}) 
public class MyTest  implements Interceptor, org.apache.ibatis.plugin.Interceptor{

	public Object intercept(Invocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}

	public Object plugin(Object target) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setProperties(Properties properties) {
		// TODO Auto-generated method stub
		
	}

}
