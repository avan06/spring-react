package com.mssoftech.springreact.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class AppContextUtil implements ApplicationContextAware {
	public ApplicationContext rootContext = null;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		System.out.println("setting context");
		this.rootContext = applicationContext;

	}

}
