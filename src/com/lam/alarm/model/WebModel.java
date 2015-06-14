package com.lam.alarm.model;
/**
 *@Title:WebModel.java
 *@Description:TODO
 *@Author:Administrator
 *@Date:2014-3-15 ÏÂÎç08:11:10
 *@Version:1.0
 */
public class WebModel {
	
	private String retCode;
	
	private String retMsg;
	
	private Object data;
	
	public WebModel() {}
	
	public WebModel(String retCode,String retMsg,Object data){
		this.retCode = retCode;
		this.retMsg = retMsg;
		this.data = data;
	}

	public String getRetCode() {
		return retCode;
	}

	public void setRetCode(String retCode) {
		this.retCode = retCode;
	}

	public String getRetMsg() {
		return retMsg;
	}

	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	

}

