package com.lam.sso;

import java.io.IOException;
import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

/**
 *@Title:SampleLoginModule.java
 *@Description:TODO
 *@Author:Administrator
 *@Date:2014-2-9 下午11:42:31
 *@Version:1.0
 */
public class SampleLoginModule implements LoginModule{
	  private boolean isAuthenticated = false;
	  private CallbackHandler callbackHandler;
	  private Subject subject;
	  private SamplePrincipal principal;

	  public void initialize(Subject subject, CallbackHandler callbackHandler,
	      Map sharedState, Map options) {
		  System.out.println("SampleLoginModule.initialize......");
	    this.subject = subject;
	    this.callbackHandler = callbackHandler;
	  }

	  public boolean login() throws LoginException {
		  System.out.println("SampleLoginModule.login......");
	    try {
	      NameCallback nameCallback = new NameCallback("username");
	      PasswordCallback passwordCallback = new PasswordCallback("password",false);
	      final Callback[] calls = new Callback[] { nameCallback, passwordCallback };

	      // 获取用户数据
	      callbackHandler.handle(calls);
	      String username = nameCallback.getName();
	      String password = String.valueOf(passwordCallback.getPassword());

	      // 验证，如：查询数据库、LDAP。。。
	      boolean correct = false;
	      if(username.equals("lam") && password.equals("test"))
	    	  correct = true;

	      if (correct) {// 验证通过
	        principal = new SamplePrincipal(username);
	        isAuthenticated = true;
	      } else {
	        throw new LoginException("user or password is wrong");
	      }

	    } catch (IOException e) {
	      throw new LoginException("no such user");
	    } catch (UnsupportedCallbackException e) {
	      throw new LoginException("login failure");
	    }
	    return isAuthenticated;
	  }

	  /**
	   * 验证后的处理,在Subject中加入用户对象
	   */
	  public boolean commit() throws LoginException {
		  System.out.println("SampleLoginModule.commit......");
	    if (isAuthenticated) {
	      subject.getPrincipals().add(principal);
	    } else {
	      throw new LoginException("Authentication failure");
	    }
	    return isAuthenticated;
	  }

	  public boolean abort() throws LoginException {
		  System.out.println("SampleLoginModule.abort......");
	    return false;
	  }

	  public boolean logout() throws LoginException {
		  System.out.println("SampleLoginModule.logout......");
	    subject.getPrincipals().remove(principal);
	    principal = null;
	    return true;
	  }
}

