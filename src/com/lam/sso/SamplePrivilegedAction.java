package com.lam.sso;

import java.security.PrivilegedAction;

/**
 *@Title:SamplePrivilegedAction.java
 *@Description:TODO
 *@Author:Administrator
 *@Date:2014-2-10 ����11:28:17
 *@Version:1.0
 */
public class SamplePrivilegedAction implements PrivilegedAction<Object>{

	public Object run() {
		System.out.println("SamplePrivilegedAction.run...");
		return null;
	}

}

