package com.mssoftech.springreact.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class PersistenceConfig {

	@Autowired
	private Environment env;

	/**
	 * Declare the JPA entity manager factory.
	 */
	@Bean
	@Primary
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setDataSource(this.dataSource());
		entityManagerFactory.setPackagesToScan(env.getProperty("entitymanager.packagesToScan")); // Classpath scanning of @Component, @Service, etc annotated class
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter(); // Vendor adapter
		entityManagerFactory.setJpaVendorAdapter(vendorAdapter); 
		entityManagerFactory.setJpaProperties(this.properties()); // Hibernate properties

		return entityManagerFactory;
	}

	@Bean
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().type(BasicDataSource.class).build();
	}

	@Bean
	@Primary
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	private Properties properties() {
		Properties properties = new Properties();
//		properties.setProperty("hibernate.hbm2ddl.auto", this.env.getProperty("spring.jpa.hibernate.ddl-auto")); //使用spring格式時為ddl-auto，使用hibernate格式時為hbm2ddl.auto

		properties.setProperty("hibernate.dialect", this.env.getProperty("spring.jpa.properties.hibernate.dialect"));
		properties.setProperty("hibernate.max_fetch_depth", this.env.getProperty("spring.jpa.properties.hibernate.max_fetch_depth"));
		properties.setProperty("hibernate.jdbc.fetch_size", this.env.getProperty("spring.jpa.properties.hibernate.jdbc.fetch_size"));
		properties.setProperty("hibernate.jdbc.batch_size", this.env.getProperty("spring.jpa.properties.hibernate.jdbc.batch_size"));
		properties.setProperty("hibernate.show_sql", this.env.getProperty("spring.jpa.properties.hibernate.show_sql"));
		properties.setProperty("hibernate.format_sql", this.env.getProperty("spring.jpa.properties.hibernate.format_sql"));
		properties.setProperty("hibernate.use_sql_comments", this.env.getProperty("spring.jpa.properties.hibernate.use_sql_comments"));
		properties.setProperty("hibernate.connection.autoReconnect", this.env.getProperty("spring.jpa.properties.hibernate.connection.autoReconnect"));
		properties.setProperty("hibernate.connection.autoReconnectForPools", this.env.getProperty("spring.jpa.properties.hibernate.connection.autoReconnectForPools"));
		properties.setProperty("hibernate.connection.is-connection-validation-required", this.env.getProperty("spring.jpa.properties.hibernate.connection.is-connection-validation-required"));
		return properties;
	}

}