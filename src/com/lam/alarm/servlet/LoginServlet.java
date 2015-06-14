package com.lam.alarm.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lam.sso.LoginManager;

/**
 *@Title:LoginServlet.java
 *@Description:TODO
 *@Author:Administrator
 *@Date:2014-2-9 ÏÂÎç11:48:45
 *@Version:1.0
 */
public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = -7066127185729232420L;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// java.security.auth.login.config=D:/jaas.conf
		System.setProperty("java.security.auth.login.config", "D:/jaas/jaas.conf");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		if(LoginManager.login(req)){
			//resp.sendRedirect("/alarm/index.jsp");
			req.getRequestDispatcher("/jsp/index.jsp").forward(req, resp);
		}else{
			//resp.sendRedirect("/alarm/error.jsp");
			req.getRequestDispatcher("/jsp/error.jsp").forward(req, resp);
		}
	}

}

