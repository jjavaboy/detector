package com.lam.alarm.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *@Title:UpAndDownloadServlet.java
 *@Description:TODO
 *@Author:Administrator
 *@Date:2014-4-8 ÏÂÎç10:45:55
 *@Version:1.0
 */
public class UpAndDownloadServlet extends HttpServlet{

	private static final long serialVersionUID = -8394359142391349498L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		ServletInputStream sis = req.getInputStream();
		
		
		int len = req.getContentLength();
		
		int index = 0;
		String tmp = null;
		
	}
	
	protected String getFilename(String name){
		System.out.println("value of input parameter name : " + name);
		String filename = null;
		if(name != null){
			int index = name.lastIndexOf("/");
			if(index != -1){
				filename = name.substring(index + 1, name.length());
			}else{
				index = name.lastIndexOf("\\");
				if(index != -1)
					filename = name.substring(index + 1, name.length());
				else
					filename = name;
			}
				
		}
		return filename;
	}
	
	protected String readLine(byte[] bytes, int[] index, ServletInputStream sis, String encoding){
		try {
			index[0] = sis.readLine(bytes, 0, bytes.length);
			if(index[0] < 0)
				return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		try {
			if(encoding == null)
				return new String(bytes ,0, index[0]);
			else
				return new String(bytes ,0, index[0] ,encoding);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

}

