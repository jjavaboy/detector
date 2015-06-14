package com.lam.sso;

import java.security.Principal;

/**
 *@Title:SamplePrincipal.java
 *@Description:TODO
 *@Author:Administrator
 *@Date:2014-2-9 ÏÂÎç11:44:10
 *@Version:1.0
 */
public class SamplePrincipal implements Principal{
	
	  private String name;

	  public SamplePrincipal(String name) {
		 System.out.println("SamplePrincipal.construct...");
	    this.name = name;
	  }

	  public String getName() {
	    return name;
	  }

	  public boolean equals(Object o) {
	    return (o instanceof SamplePrincipal)
	        && this.name.equalsIgnoreCase(((SamplePrincipal) o).name);
	  }

	  public int hashCode() {
	    return name.toUpperCase().hashCode();
	  }


}

