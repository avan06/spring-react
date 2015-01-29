package com.mssoftech.springreact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableAspectJAutoProxy
@EnableTransactionManagement
@EnableAutoConfiguration
@ComponentScan
public class Application {
	public static AnnotationConfigWebApplicationContext annotationConfigWebApplicationContext = null;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setSuffix(".jsp");
		resolver.setOrder(2);
		resolver.setPrefix("/WEB-INF/views/");
		return resolver;
	}

}
