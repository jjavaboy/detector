package com.lam.alarm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.lam.alarm.model.WebModel;
import com.lam.alarm.util.RespUtil;
import com.lam.alarm.util.Utils;

/**
 *@Title:BaseController.java
 *@Description:TODO
 *@Author:Administrator
 *@Date:2014-3-14 ÉÏÎç12:02:21
 *@Version:1.0
 */
public abstract class BaseController {
	
	protected Log log = LogFactory.getLog(getClass());
	protected HttpServletRequest request;
	protected WebModel resp = new WebModel();
	protected String userCode;
	protected String ip;
	
	protected void prepare(HttpServletRequest _request){
		if(_request != null){
			request = _request;
			ip = request.getRemoteAddr();
			userCode = request.getRemoteUser();
			if(Utils.isNull(userCode)){
				RespUtil.resp4fail(resp, "not login");
			}else{
		    }
		}else{
			RespUtil.resp4fail(resp, "request is null");
		}
	}
	
	protected void responseSetting(HttpServletResponse response){
		encodingUTF8(response);
		contextTypeHtml(response);
	}
	
	protected void encodingUTF8(HttpServletResponse response){
		response.setCharacterEncoding("utf-8");
	}
	
	protected void contextTypeHtml(HttpServletResponse response){
		response.setContentType("text/html");
	}

}

