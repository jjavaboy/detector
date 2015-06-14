package com.lam.alarm.util;

import java.util.Map;

/**
 *@Title:Utils.java
 *@Description:TODO
 *@Author:Administrator
 *@Date:2014-3-14 ионГ12:24:50
 *@Version:1.0
 */
public class Utils {
	
	public static boolean isNull(String str){
		if(str == null || str.equals("null") || str.trim().equals("")){
			return true;
		}
		return false;
	}
	
	public static String getValue(Map map , String key){
		return nvl(String.valueOf(map.get(key)));
	}
	
	public static String nvl(String str){
		if(isNull(str))
			return "";
		return str.trim();
	}

}

