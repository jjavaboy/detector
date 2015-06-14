package com.lam.alarm.log;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;

/**
 *@Title:LogBase.java
 *@Description:TODO
 *@Author:Administrator
 *@Date:2014-3-10 ÏÂÎç11:07:43
 *@Version:1.0
 */
public abstract class LogBase implements ILog{
	
	private static String configFile = "log4j.properties";
	
	public static void init() throws IOException{
		System.out.println("LogBase.init()...");
		InputStream inStream = LogBase.class.getResourceAsStream(configFile);
		Properties properties = new Properties();
		properties.load(inStream);
		PropertyConfigurator.configure(properties);
		//PropertyConfigurator.configure(configFile);
	}

}

