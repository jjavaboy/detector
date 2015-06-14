package com.lam.alarm.service;

import java.util.List;
import java.util.Map;

import com.lam.alarm.dao.IndexDao;
import com.lam.alarm.log.AlarmLog;
import com.lam.alarm.model.WebModel;
import com.lam.alarm.util.RespUtil;
import com.lam.alarm.util.Utils;

/**
 *@Title:IndexService.java
 *@Description:TODO
 *@Author:Administrator
 *@Date:2014-3-13 下午10:44:05
 *@Version:1.0
 */
public class IndexService {
	
	private IndexDao indexDao;
	private WebModel resp;
	
	public void setResp(WebModel resp) {
		this.resp = resp;
	}
	
	public void setIndexDao(IndexDao indexDao) {
		this.indexDao = indexDao;
	}
	
	public void isUserExist(String user_code, String user_pass){
		if(Utils.isNull(user_code)){
			RespUtil.resp4fail(resp,"账号不能空");
			return;
		}
		if(Utils.isNull(user_pass)){
			RespUtil.resp4fail(resp,"密码不能空");
			return;
		}
		List users = indexDao.queryUserForLogin(user_code);
		if(users == null || users.size() == 0){
			RespUtil.resp4fail(resp,"账号不存在");
			return;
		}
		Map user = (Map) users.get(0);
		String password = Utils.getValue(user, "password");
		//encrypt password ...
		AlarmLog.debug(this, "isUserExist,user_pass:"+user_pass+",password:"+password);
		if(!password.equals(user_pass)){
			RespUtil.resp4fail(resp,"账号或密码错误");
		}else{
			RespUtil.resp4succ(resp,"账号和密码正确");
		}
	}

}

