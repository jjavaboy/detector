package com.lam.spring;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;


/**
 * need aspectjrt.jar, aspectjweaver.jar
 *@Title:ServiceAspect.java
 *@Description:TODO
 *@Author:Administrator
 *@Date:2015年4月14日 下午10:30:26
 *@Version:1.0
 */
public class ServiceAspect {
	
	public void doAfter(JoinPoint jp){
		System.out.println("after method:" 
				+ jp.getTarget().getClass().getName() + "." + jp.getSignature().getName());
	}
	
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable{
		long startTime = System.currentTimeMillis();
		Object ret = pjp.proceed();
		long endTime = System.currentTimeMillis();
		System.out.println("process time:" + (endTime - startTime));
		return ret;
	}
	
	public void doBefore(JoinPoint jp){
		System.out.println("before method:" 
				+ jp.getTarget().getClass().getName() + "." + jp.getSignature().getName());
	}
	
	public void doThrowing(JoinPoint jp, Throwable th){
		System.out.println("method:" 
				+ jp.getTarget().getClass().getName() + "." + jp.getSignature().getName() 
				+ " throw Throwable. " + th.getMessage());
	}

}

