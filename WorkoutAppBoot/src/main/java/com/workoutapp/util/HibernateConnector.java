/*package com.workoutapp.util;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;

@Configuration
public class HibernateConnector 
{
    @Value("${spring.datasource.driver-class-name}")
    private static String DRIVER;

    @Value("${spring.datasource.password}")
    private static String PASSWORD;

    @Value("${spring.datasource.url}")
    private static String URL;

    @Value("${spring.datasource.username}")
    private static String USERNAME;

    @Value("${spring.jpa.database-platform}")
    private static String DIALECT;

    @Value("${spring.jpa.show-sql}")
    private static String SHOW_SQL;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private static String HBM2DDL_AUTO;


    @Bean
    public static DataSource dataSource() 
    {
    	System.out.println(DRIVER+","+URL+","+USERNAME+","+PASSWORD+","+DIALECT+","+SHOW_SQL+","+HBM2DDL_AUTO);
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(DRIVER);
        dataSource.setUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);
        return dataSource;
    }
	
	
}*/