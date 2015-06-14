package com.lam.sso;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;

/**
 *@Title:SampleCallbackHandler.java
 *@Description:TODO
 *@Author:Administrator
 *@Date:2014-2-9 ÏÂÎç11:38:29
 *@Version:1.0
 */
public class SampleCallbackHandler implements CallbackHandler{
	  private String username;
	  private String password;
	
	  public SampleCallbackHandler(final String username, final String password) {
		  System.out.println("SampleCallbackHandler.construct...");
	    this.username = username;
	    this.password = password;
	  }
	
	  public void handle(Callback[] callbacks) throws IOException,
	      UnsupportedCallbackException {
		  System.out.println("SampleCallbackHandler.handle...");
	    for (int index = 0; index < callbacks.length; index++) {
	      if (callbacks[index] instanceof NameCallback) {
	        NameCallback ncb = (NameCallback) callbacks[index];
	        ncb.setName(username);
	      }
	      if (callbacks[index] instanceof PasswordCallback) {
	        PasswordCallback pcb = (PasswordCallback) callbacks[index];
	        pcb.setPassword(password.toCharArray());
	      }
	    }
	  }
}

