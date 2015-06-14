package com.lam.alarm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lam.alarm.dao.DetectorDao;
import com.lam.alarm.log.AlarmLog;
import com.lam.alarm.model.WebModel;
import com.lam.alarm.service.DetectorService;
import com.lam.alarm.util.RespUtil;
import com.lam.alarm.util.SpringUtils;

/**
 *@Title:DetectorController.java
 *@Description:TODO
 *@Author:Administrator
 *@Date:2014-5-1 下午03:20:31
 *@Version:1.0
 */
@Controller
@RequestMapping(value="detecotr")
public class DetectorController extends BaseController{
	
	@Autowired
	private DetectorService detectorService;
	
	@RequestMapping(value="test",method=RequestMethod.POST)
	@ResponseBody
	public WebModel test(HttpServletRequest req){
		RespUtil.resp4succ("成功");
		return resp;
	}
	
	@RequestMapping(value="insertDepartment",method=RequestMethod.POST)
	@ResponseBody
	public WebModel insertDepartment(HttpServletRequest request, HttpServletResponse response){
		try{
			detectorService.insertDepartment();
			RespUtil.resp4succ(resp, "成功");
		}catch(Exception e){
			AlarmLog.info(e, e.getMessage());
			RespUtil.resp4fail(resp, "失败");
		}
		return resp;
	}
	
	@RequestMapping(value="transaction",method=RequestMethod.POST)
	@ResponseBody
	public WebModel transaction(HttpServletRequest request, HttpServletResponse response){
		try{
			detectorService.test_transaction();
			RespUtil.resp4succ(resp, "成功");
		}catch(Exception e){
			AlarmLog.info(e, e.getMessage());
			RespUtil.resp4fail(resp, "失败");
		}
		return resp;
	}

}

