package com.lam.sso;

import java.security.Principal;
import java.security.PrivilegedAction;
import java.util.Set;

import javax.security.auth.Subject;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;

/**
 *@Title:LoginManager.java
 *@Description:TODO
 *@Author:Administrator
 *@Date:2014-2-9 下午11:36:30
 *@Version:1.0
 */
public class LoginManager {
	public static boolean login(HttpServletRequest request) {
	    try {
	      String username = request.getParameter("username");
	      String password = request.getParameter("password");
	      //此处指定了使用配置文件的“Sample”验证模块，对应的实现类为SampleLoginModule
	      LoginContext lc = new LoginContext("Sample", new SampleCallbackHandler(
	          username, password));
	      lc.login();// 如果验证失败会抛出异常
	      
	      Subject subject = lc.getSubject();
	      Set<Principal> principals = subject.getPrincipals();
	      for(Principal principal : principals){
	    	  System.out.println("Principal:"+principal.getName());
	      }
	      PrivilegedAction<Object> privilegedAction = new SamplePrivilegedAction();
	      Subject.doAsPrivileged(subject, privilegedAction, null);
	      
	      return true;
	    } catch (LoginException e) {
	      e.printStackTrace();
	      return false;
	    } catch (SecurityException e) {
	      e.printStackTrace();
	      return false;
	    }
	  }
}

