package com.lam.alarm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lam.alarm.log.AlarmLog;
import com.lam.alarm.model.WebModel;
import com.lam.alarm.service.IndexService;
import com.lam.alarm.util.SpringUtils;

/**
 *@Title:IndexController.java
 *@Description:TODO
 *@Author:Administrator
 *@Date:2014-3-1 ÏÂÎç04:18:39
 *@Version:1.0
 */
@Controller
@RequestMapping(value="index")
public class IndexController extends BaseController /*implements ServletContextAware*/{
	
	//private ServletContext servletContext;
	
	@Autowired
	private IndexService indexService;
	
	public IndexController(){ super(); }
	
	/*@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}*/
	
	@RequestMapping(value="/hello")
	public ModelAndView handleHello(HttpServletRequest request,HttpServletResponse resposne){
		AlarmLog.info(this, "request into ...");
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", "I am from IndexController.");
		mav.setViewName("helloworld");
		return mav;
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request,HttpServletResponse resposne){
		AlarmLog.debug(this, "user : " + request.getRemoteUser()+" , logout...");
		request.getSession().invalidate();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("logout");
		return mav;
	}
	
	@RequestMapping(value="/checkUser",method=RequestMethod.POST)
	@ResponseBody
	public WebModel isUserExist(HttpServletRequest req){
		String user_code = req.getParameter("user_code");
		String user_pass = req.getParameter("user_pass");
		//IndexService indexService = (IndexService) SpringUtils.getBean("indexService", req);
		indexService = SpringUtils.getBean("indexService", req, IndexService.class);
		indexService.setResp(resp);
		indexService.isUserExist(user_code,user_pass);
		return resp;
	}

}

