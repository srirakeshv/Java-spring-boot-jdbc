package com.wipro.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:database.properties")
public class JdbcConfiguration {

	@Autowired
	private Environment environment;

	@Bean
	public DataSource dataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getProperty("oracle.jdbc.driver"));
		dataSource.setUrl(environment.getProperty("oracle.jdbc.url"));
		dataSource.setUsername(environment.getProperty("oracle.jdbc.user"));
		dataSource.setPassword(environment.getProperty("oracle.jdbc.password"));
		return dataSource;

	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}

}

//Environment: Retrieves database connection details (driver class, URL, username, password) 
//from the database.properties file.

//DriverManagerDataSource: Configures these details to establish a connection to the Oracle database.

//JdbcTemplate: Uses the configured DataSource to perform JDBC operations 
//(such as querying, updating, inserting, and deleting data).
