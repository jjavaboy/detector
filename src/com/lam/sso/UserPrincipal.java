package com.lam.sso;

import java.security.Principal;

/**
 *@Title:UserPrincipal.java
 *@Description:TODO
 *@Author:Administrator
 *@Date:2014-2-17 обнГ11:52:50
 *@Version:1.0
 */
public class UserPrincipal implements Principal{
	
	private String user;
	
	public UserPrincipal(String _user){
		user = _user;
	}

	@Override
	public String getName() {
		return user;
	}

}

