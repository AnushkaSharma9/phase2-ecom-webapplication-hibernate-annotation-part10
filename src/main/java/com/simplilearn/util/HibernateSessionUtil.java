package com.simplilearn.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.simplilearn.model.Product;

public class HibernateSessionUtil {
	
	private static SessionFactory factory;
	
	public static SessionFactory buildSessionFactory() {
		factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Product.class)
				.buildSessionFactory();
		return factory;
	}

}