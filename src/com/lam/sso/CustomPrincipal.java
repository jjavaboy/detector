package com.lam.sso;

import java.security.Principal;

/**
 *@Title:CustomPrincipal.java
 *@Description:TODO
 *@Author:Administrator
 *@Date:2014-2-16 обнГ11:08:57
 *@Version:1.0
 */
public class CustomPrincipal implements Principal{
	
	private String name;
	
	public CustomPrincipal(){}
	
	public CustomPrincipal(String _name){
		name = _name;
	}

	@Override
	public String getName() {
		return null;
	}

}

