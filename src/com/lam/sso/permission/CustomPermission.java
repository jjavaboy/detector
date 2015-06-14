package com.lam.sso.permission;

import java.security.Permission;


/**
 *@Title:CustomPermission.java
 *@Description:TODO
 *@Author:Administrator
 *@Date:2014-2-16 ÏÂÎç11:07:17
 *@Version:1.0
 */
public class CustomPermission extends Permission{

	public CustomPermission(String name) {
		super(name);
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getActions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean implies(Permission permission) {
		// TODO Auto-generated method stub
		return false;
	}

}

