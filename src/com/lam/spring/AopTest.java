package com.lam.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * need cglib-nodep-2.1_3.jar
 *@Title:AopTest.java
 *@Description:TODO
 *@Author:Administrator
 *@Date:2015年4月14日 下午11:01:21
 *@Version:1.0
 */
public class AopTest {

	public static void main(String[] args) {
		ApplicationContext appCtx = new ClassPathXmlApplicationContext(
				"file:F:\\JSPproject\\alarm\\WebRoot\\WEB-INF\\applicationContext.xml");
        AService aService = (AService) appCtx.getBean("aService");
        BServiceImpl bService = (BServiceImpl) appCtx.getBean("bService");
        
        aService.barA();
        aService.fooA("I am arguments A.");

        bService.barB("I am arguments B.", -1);
        bService.fooB();
        
	}

}

