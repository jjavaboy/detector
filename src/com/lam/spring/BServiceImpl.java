package com.lam.spring;
/**
 *@Title:BServiceImpl.java
 *@Description:TODO
 *@Author:Administrator
 *@Date:2015年4月14日 下午10:24:39
 *@Version:1.0
 */
public class BServiceImpl {
	
	public void barB(String msg, int type){
		System.out.println("BServiceImpl.barB, msg:" + msg + ", type:" + type);
		if(type == -1){
			throw new IllegalArgumentException("type:" + type);
		}
	}
	
	public void fooB(){
		System.out.println("AServiceImpl.fooB");
	}

}

