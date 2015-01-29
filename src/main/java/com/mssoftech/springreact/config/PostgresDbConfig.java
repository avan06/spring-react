package com.mssoftech.springreact.config;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
public class PostgresDbConfig {
	private BasicDataSource dataSource;

	@Bean
	public DataSource dataSource() {
		URI dbUri;
		try {
			String username = "test";
			String password = "testpass";
			String url = "jdbc:postgresql://localhost/react";
			String dbProperty = System.getenv("DATABASE_URL");
			if (dbProperty != null) {
				dbUri = new URI(dbProperty);

				username = dbUri.getUserInfo().split(":")[0];
				password = dbUri.getUserInfo().split(":")[1];
				url = "jdbc:postgresql://" + dbUri.getHost() + ':'
						+ dbUri.getPort() + dbUri.getPath();
			}

			BasicDataSource basicDataSource = new BasicDataSource();
			basicDataSource.setUrl(url);
			basicDataSource.setUsername(username);
			basicDataSource.setPassword(password);
			this.dataSource = basicDataSource;
			return basicDataSource;

		} catch (URISyntaxException e) {
			// Deal with errors here.
		}
		return null;
	}

	@Bean
	public DataSourceTransactionManager transactionManager() {
		// TransactionManager
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(
				dataSource);
		// TransactionInterceptor
		Properties properties = new Properties();
		properties.setProperty("*", "PROPAGATION_REQUIRED");
		return transactionManager;
	}
}
