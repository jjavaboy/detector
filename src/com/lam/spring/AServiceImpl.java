package com.lam.spring;
/**
 *@Title:AServiceImpl.java
 *@Description:TODO
 *@Author:Administrator
 *@Date:2015年4月14日 下午10:23:34
 *@Version:1.0
 */
public class AServiceImpl implements AService{

	@Override
	public void fooA(String msg) {
		System.out.println("AServiceImpl.fooA, msg" + msg);
	}

	@Override
	public void barA() {
		System.out.println("AServiceImpl.barA");
	}

}

