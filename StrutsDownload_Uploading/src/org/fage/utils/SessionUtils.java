package org.fage.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionUtils {
private static SessionFactory factory;
	
	static{
		StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		factory = new MetadataSources(standardServiceRegistry).buildMetadata().buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory(){
		return factory;
	}
	
	public static Session getCurrentSession(){
		return factory.getCurrentSession();
	}
	
}
