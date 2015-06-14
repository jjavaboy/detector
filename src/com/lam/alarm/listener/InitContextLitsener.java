package com.lam.alarm.listener;

import java.io.IOException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.lam.alarm.log.LogBase;

/**
 *@Title:InitContextLisener.java
 *@Description:TODO
 *@Author:Administrator
 *@Date:2014-3-11 ÏÂÎç11:02:27
 *@Version:1.0
 */
public class InitContextLitsener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		try {
			LogBase.init();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

