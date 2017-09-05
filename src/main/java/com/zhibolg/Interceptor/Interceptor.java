package com.zhibolg.Interceptor;

import java.util.Properties;

import org.apache.ibatis.plugin.Invocation;

public interface Interceptor {

	Object intercept(Invocation invocation) throws Throwable;

	Object plugin(Object target);

	void setProperties(Properties properties);

}