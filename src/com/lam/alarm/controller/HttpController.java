package com.lam.alarm.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *@Title:HttpController.java
 *@Description:TODO
 *@Author:Administrator
 *@Date:2015-2-10 ÏÂÎç10:19:54
 *@Version:1.0
 */
@Controller
@RequestMapping(value="http")
public class HttpController {
	
	@RequestMapping(value="htmlGetMethod", method={RequestMethod.GET})
	@ResponseBody
	public String htmlGetMethod(HttpServletRequest request, HttpServletResponse response){
		
		analyse(request);
		
		return "result of htmlGetMethod";
	}
	
	@RequestMapping(value="htmlPostMethod", method={RequestMethod.POST})
	@ResponseBody
	public String htmlPostMethod(HttpServletRequest request, HttpServletResponse response){
		
		analyse(request);
		
		return "result of htmlPostMethod";
	}
	
	@RequestMapping(value="ajaxGetMethod", method={RequestMethod.GET})
	@ResponseBody
	public String ajaxGetMethod(HttpServletRequest request, HttpServletResponse response){
		
		analyse(request);
		
		return "result of ajaxGetMethod";
	}
	
	@RequestMapping(value="ajaxPostMethod", method={RequestMethod.POST})
	@ResponseBody
	public String ajaxPostMethod(HttpServletRequest request, HttpServletResponse response){
		
		analyse(request);
		
		return "result of ajaxPostMethod";
	}
	
	@RequestMapping(value="method1",method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String method(HttpServletRequest request,HttpServletResponse response){
		StringBuffer url = request.getRequestURL();
		String queryString = request.getQueryString();
		System.out.println("method:" + request.getMethod() + " :" + url);
		System.out.println("queryString , byte length:" + queryString.getBytes().length + " :" + queryString);
		
		StringBuilder sb = new StringBuilder();
		String header ;
		Enumeration en = request.getHeaderNames();
		while(en.hasMoreElements()){
			header = (String) en.nextElement();
			sb.append(header + ":" + request.getHeader(header) + "\r\n");
		}
		System.out.println(sb.toString());
		
		try {
			int len;
			char[] ch = new char[2048];
			StringBuilder sb1 = new StringBuilder();
			InputStreamReader isr = new InputStreamReader(request.getInputStream());
			while((len = isr.read(ch, 0, ch.length)) != -1){
				sb1.append(ch, 0, len);
			}
			System.out.println(sb1.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	private void analyseMultipart(HttpServletRequest request){
		//multipart/form-data; boundary=---------------------------257881762317299
		String contentType = request.getContentType();
		String[] contentTypes = contentType.split(";");
		String boundary = null, boundaryEnd = null;
		if(contentTypes.length > 1){
			boundary = contentTypes[1].substring(contentTypes[1].indexOf("=") + 1);
			boundaryEnd = boundary + "--";
		}
		
		try {
			String line;
			BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
			while( (line = reader.readLine()) != null){
				if(line.indexOf(boundaryEnd) != -1){
					
				}else if(line.indexOf(boundary) != -1){
					
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void analyse(HttpServletRequest request){
		System.out.println("url:" + request.getRequestURL().toString() + 
				"\nqueryString:" + request.getQueryString() + 
				"\nmethod:" + request.getMethod() + 
				"\nauthType:" + request.getAuthType() + 
				"\ncharacterEncoding:" + request.getCharacterEncoding() + 
				"\ncontentLength:" + request.getContentLength() + 
				"\ncontentType:" + request.getContentType());
		
		String name;
		Enumeration<String> headerNames = request.getHeaderNames();
		System.out.println("-------------------------header:");
		while(headerNames.hasMoreElements()){
			name = headerNames.nextElement();
			System.out.println(name + ":" + request.getHeader(name));
		}
		
		
		try {
			int len;
			char[] ch = new char[2048];
			StringBuilder sb = new StringBuilder();
			InputStreamReader reader = new InputStreamReader(request.getInputStream());
			while( (len = reader.read(ch, 0, ch.length)) != -1){
				sb.append(ch, 0, len);
			}
			System.out.println("-------------------------inputStream:\n" + sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Enumeration<String> parameterNames = request.getParameterNames();
		System.out.println("-------------------------parameter:");
		while(parameterNames.hasMoreElements()){
			name = parameterNames.nextElement();
			System.out.println(name + ":" + request.getParameter(name));
		}
	}
	
	@RequestMapping(value="submitForm",method={RequestMethod.GET, RequestMethod.POST})
	public String handleSubmitForm(HttpServletRequest request,HttpServletResponse response){
		System.out.println(request.getRequestURL().toString());
		System.out.println(request.getQueryString());
		
		StringBuilder sb = new StringBuilder();
		String header ;
		Enumeration en = request.getHeaderNames();
		while(en.hasMoreElements()){
			header = (String) en.nextElement();
			sb.append(header + ":" + request.getHeader(header) + "\r\n");
		}
		System.out.println(sb.toString());
		
		try {
			int len;
			char[] ch = new char[2048];
			StringBuilder sb1 = new StringBuilder();
			InputStreamReader isr = new InputStreamReader(request.getInputStream());
			while((len = isr.read(ch, 0, ch.length)) != -1){
				sb1.append(ch, 0, len);
			}
			System.out.println(sb1.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}

