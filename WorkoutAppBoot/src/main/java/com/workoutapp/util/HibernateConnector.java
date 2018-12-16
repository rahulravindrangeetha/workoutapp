package com.workoutapp.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
public class HibernateConnector 
{
	
	private static SessionFactory sessionFactory = buildSessionFactory();

private static SessionFactory buildSessionFactory()
{
   try
   {
      if (sessionFactory == null)
      {    	  
    	  StandardServiceRegistry standardRegistry = 
    		       new StandardServiceRegistryBuilder().configure().build();
    			Metadata metaData = 
    		        new MetadataSources(standardRegistry).getMetadataBuilder().build();
    			sessionFactory = metaData.getSessionFactoryBuilder().build();   
    	
      }
      return sessionFactory;
   } catch (Throwable ex)
   {
      System.err.println("Initial SessionFactory creation failed." + ex);
      throw new ExceptionInInitializerError(ex);
   }
}

public static SessionFactory getSessionFactory()
{
   return sessionFactory;
}

public static void shutdown()
{
   getSessionFactory().close();
}
}