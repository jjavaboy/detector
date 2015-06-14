package com.lam.alarm.util;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 *@Title:SpringBeanUtils.java
 *@Description:TODO
 *@Author:Administrator
 *@Date:2014-3-14 ÉÏÎç12:38:51
 *@Version:1.0
 */
public class SpringUtils {
	
	public static Object getBean(String bean,HttpServletRequest request){
		return getBean(bean,request.getSession().getServletContext());
	}
	
	public static Object getBean(String bean,ServletContext servletContext){
		return WebApplicationContextUtils.getWebApplicationContext(servletContext).getBean(bean);
	}
	
	public static <T> T getBean(String bean,HttpServletRequest request,Class<T> requiredType){
		return getBean(bean,request.getSession().getServletContext(),requiredType);
	}
	
	public static <T> T getBean(String bean,ServletContext servletContext,Class<T> requiredType){
		return WebApplicationContextUtils.getWebApplicationContext(servletContext)
				.getBean(bean,requiredType);
	}

}

