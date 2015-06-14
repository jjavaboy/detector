package com.lam.alarm.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;

import com.lam.jaas.core.util.DateUtil;

/**
 *@Title:JaasLog.java
 *@Description:TODO
 *@Author:Administrator
 *@Date:2014-2-16 ÏÂÎç09:00:22
 *@Version:1.0
 */
public class AlarmLog extends LogBase{
	
	private static Log log ;
	private static AlarmLog instance;
	
	static final String APP_NAME = "alarm";
	static final String INFO = "INFO";
	static final String DEBUG = "DEBUG";
	static final String ERROR = "ERROR";

	public static Log getLog(Class clazz){
		return LogFactory.getLog(clazz);
	}
	
	public Log log(Class clazz) {
		return LogFactory.getLog(clazz);
	}
	
	public static void info(Object o ,String msg){
		log = LogFactory.getLog(o.getClass());
		if(log.isInfoEnabled()){			
			info(msg);
		}
	}
	
	public static void debug(Object o ,String msg){
		log = LogFactory.getLog(o.getClass());
		if(log.isDebugEnabled()){			
			debug(msg);
		}
	}
	
	public static void error(Object o ,String msg){
		log = LogFactory.getLog(o.getClass());
		if(log.isErrorEnabled()){			
			error(msg);
		}
	}
	
	private static void info(String msg){
		log.info(msg);
	}
	
	private static void debug(String msg){
		log.debug(msg);
	}
	
	private static void error(String msg){
		log.error(msg);
	}

}

