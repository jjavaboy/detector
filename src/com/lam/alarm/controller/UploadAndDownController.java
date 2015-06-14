package com.lam.alarm.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;



/**
 *@Title:UploadController.java
 *@Description:TODO
 *@Author:Administrator
 *@Date:2014-4-7 下午07:55:51
 *@Version:1.0
 */
@Controller
@RequestMapping(value="uploadAndDown")
public class UploadAndDownController extends BaseController {
	
	@RequestMapping(value="upload",method={RequestMethod.GET, RequestMethod.POST})
	public String handleUpload(HttpServletRequest request,HttpServletResponse response){
		/*System.out.println(request.getRequestURL().toString());
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
		}*/
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		CommonsMultipartFile cmFile = (CommonsMultipartFile)multipartRequest.getFile("firstFile");
		PrintWriter out = null;
		if(!cmFile.isEmpty()){
			try {
				File uploadFile = new File("d:"+File.separator+"temp"+File.separator+cmFile.getFileItem().getName());
				if(uploadFile.isDirectory())
					uploadFile.delete();
				if(!uploadFile.exists()){
					File dir = new File("d:"+File.separator+"temp");
					if(!dir.exists()) dir.mkdirs();
					uploadFile.createNewFile();
				}
				cmFile.getFileItem().write(uploadFile);
				
				responseSetting(response);
				out = response.getWriter();
				out.write("<script>parent.uploadCallback('上传成功。');</script>");
			} catch (Exception e) {
				log.error(e);
			} finally {
				if(out != null)
					out.close();
			}
		}else{
			log.error("file name " + cmFile.getName()+ " uploaded is empty.");
		}
		return null;
	}
	
	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public String handleMaxUploadSizeExceededException(MaxUploadSizeExceededException ex, 
			HttpServletRequest request,HttpServletResponse response){
		PrintWriter out = null;
		try {
			responseSetting(response);
			out = response.getWriter();
			out.write("<script>parent.uploadCallback('上传文件太大。');</script>");
		} catch (IOException e) {
			log.error(e,e);
		} finally {
			if(out != null)
				out.close();
		}
		return null;
	}

	public void viewFile(HttpServletRequest request,HttpServletResponse response){
		
	}

}

