package com.lam.alarm.util;

import com.lam.alarm.model.WebModel;

/**
 *@Title:RespModel.java
 *@Description:TODO
 *@Author:Administrator
 *@Date:2014-3-13 ÏÂÎç10:58:06
 *@Version:1.0
 */
public class RespUtil {
	
	private static final String CODE_FAIL = "0";
	private static final String CODE_SUCC = "1";
	
	public static boolean isFail(WebModel web){
		return web.getRetCode().equals(CODE_FAIL);
	}
	
	public static boolean isSucc(WebModel web){
		return web.getRetCode().equals(CODE_SUCC);
	}
	
	public static void resp4req(WebModel web,String code,String msg,Object data){
		web.setRetCode(code);
		web.setRetMsg(msg);
		web.setData(data);
	}
	
	public static void resp4fail(WebModel web,String msg,Object data){
		resp4req(web,CODE_FAIL,msg,data);
	}
	
	public static void resp4fail(WebModel web,String msg){
		resp4req(web,CODE_FAIL,msg,null);
	}
	
	public static void resp4succ(WebModel web,String msg,Object data){
		resp4req(web,CODE_SUCC,msg,data);
	}
	
	public static void resp4succ(WebModel web,String msg){
		resp4req(web,CODE_SUCC,msg,null);
	}
	
	public static WebModel resp4req(String code,String msg,Object data){
		return new WebModel(code,msg,data);
	}
	
	public static WebModel resp4fail(String msg,Object data){
		return resp4req(CODE_FAIL,msg,data);
	}
	
	public static WebModel resp4fail(String msg){
		return resp4req(CODE_FAIL,msg,null);
	}
	
	public static WebModel resp4succ(String msg,Object data){
		return resp4req(CODE_SUCC,msg,data);
	}
	
	public static WebModel resp4succ(String msg){
		return resp4req(CODE_SUCC,msg,null);
	}

}

