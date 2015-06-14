package com.lam.sso.policy;

import java.security.CodeSource;
import java.security.PermissionCollection;
import java.security.Policy;
import java.security.Principal;
import java.security.ProtectionDomain;

import com.lam.sso.CustomPrincipal;
import com.lam.sso.permission.CustomPermission;



/**
 *@Title:CustomPolicy.java
 *@Description:TODO
 *@Author:Administrator
 *@Date:2014-2-16 ÏÂÎç10:46:14
 *@Version:1.0
 */
public class CustomPolicy extends Policy{
	
	private Policy deferredPolicy;
	
	public CustomPolicy(Policy p){
		deferredPolicy = p;
	}

	@Override
	public PermissionCollection getPermissions(CodeSource codesource) {
		PermissionCollection pc = deferredPolicy.getPermissions(codesource);
		return pc;
	}
	
	@Override
	public PermissionCollection getPermissions(ProtectionDomain domain) {
		PermissionCollection pc = deferredPolicy.getPermissions(domain);
		Principal[] principals = domain.getPrincipals();
		System.out.println("retrieved " + principals.length + " principals");
		
		for (int i=0; i< principals.length; i++) {
			
			Principal p = principals[i];
			System.out.println("This is principal" + p);
			CustomPermission[] pms = null;
			if (p instanceof CustomPrincipal ) {
				
				System.out.println(p.getName()  + " is a CustomPrincipal");
				
				// Get the permissions belonging to the principal here.
				// Here we just add an example permission
				CustomPermission[] test =  { new CustomPermission("AccessToCompany1Building") };
				pms = test;
			} else {
			}

			// Nothing to do
			if (pms == null)  continue;

			for(int j=0; j< pms.length; j++) {
				System.out.println("Adding permission = " + pms[j]);
				pc.add(pms[j]);
			}

		}

		System.out.println(pc);
		return pc;
	}

}

