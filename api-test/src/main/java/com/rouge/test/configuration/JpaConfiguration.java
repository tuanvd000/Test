package com.rouge.test.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

public class JpaConfiguration {

	@Autowired
	private Environment env;

	@Bean
	public DataSource dataSource(){
	      DriverManagerDataSource dataSource = new DriverManagerDataSource();
	      dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
	      dataSource.setUrl(env.getProperty("spring.datasource.url"));
	      dataSource.setUsername(env.getProperty("spring.datasource.username"));
	      dataSource.setPassword(env.getProperty("spring.datasource.password"));
	      return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	      LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
	      em.setDataSource(dataSource());
	      em.setPackagesToScan("com.rouge.test");

	      JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	      em.setJpaVendorAdapter(vendorAdapter);
	      em.setJpaProperties(additionalProperties());

	      return em;
	}
	
    private Properties additionalProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.id.new_generator_mappings","false");
        return properties;
    }
}
