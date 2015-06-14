package com.lam.alarm.test;

import org.springframework.util.ResourceUtils;

/**
 *@Title:DetectorResourceUtils.java
 *@Description:TODO
 *@Author:Administrator
 *@Date:2014-5-30 ионГ12:32:49
 *@Version:1.0
 */
public class DetectorResourceUtils extends ResourceUtils{
	
	static{
		String i = CLASSPATH_URL_PREFIX;
	}
	
	public static void main(String[] args){
		//DetectorResourceUtils d = new DetectorResourceUtils();
		String j =DetectorResourceUtils.CLASSPATH_URL_PREFIX;
	}

}

