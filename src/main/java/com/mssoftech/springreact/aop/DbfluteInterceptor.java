//package com.mssoftech.springreact.aop;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
//@Aspect
//@Component
//public class DbfluteInterceptor {
//	static protected Logger log =LoggerFactory.getLogger(DbfluteInterceptor.class);
//	
//	@After("execution(* com.mssoftech.springreact.control.*Control.*(..))")
//	public void afterInterceptor(JoinPoint joinPoint) {
//		log.debug("ActionAccessContextIntercepter End");
//	}
//	@Before("execution(* com.mssoftech.springreact.control.*Control.*(..))")
//	public void beforeInterceptor(JoinPoint joinPoint) {
//		log.debug("ActionAccessContextIntercepter Begin");
//	}
//}
