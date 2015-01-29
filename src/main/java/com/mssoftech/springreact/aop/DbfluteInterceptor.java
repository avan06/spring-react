package com.mssoftech.springreact.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.dbflute.hook.AccessContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DbfluteInterceptor {
	static protected Logger log =LoggerFactory.getLogger(DbfluteInterceptor.class);
	
	@After("execution(* com.mssoftech.springreact.control.*Control.*(..))")
	public void afterInterceptor(JoinPoint joinPoint) {
        AccessContext.clearAccessContextOnThread();
		log.debug("ActionAccessContextIntercepter End");
	}
	@Before("execution(* com.mssoftech.springreact.control.*Control.*(..))")
	public void beforeInterceptor(JoinPoint joinPoint) {
		AccessContext ac = new AccessContext();
		ac.setAccessUser("");
		ac.setAccessProcess("");
		AccessContext.setAccessContextOnThread(ac);
		log.debug("ActionAccessContextIntercepter Begin");
	
	}
}
