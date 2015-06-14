package com.lam.sso;

import java.security.Principal;

/**
 *@Title:RolePrincipal.java
 *@Description:TODO
 *@Author:Administrator
 *@Date:2014-2-17 обнГ11:54:25
 *@Version:1.0
 */
public class RolePrincipal implements Principal{
	
	private String role;

	public RolePrincipal(String _role){
		role = _role;
	}
	
	@Override
	public String getName() {
		return role;
	}

}

