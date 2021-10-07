package com.simplilearn.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.simplilearn.model.Order;
import com.simplilearn.model.Payment;
import com.simplilearn.model.Product;
import com.simplilearn.model.ProductDetails;

public class HibernateSessionUtil {
	
	private static SessionFactory factory;
	
	public static SessionFactory buildSessionFactory() {
		factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Product.class)
				.addAnnotatedClass(ProductDetails.class)
				.addAnnotatedClass(Order.class)
				.addAnnotatedClass(Payment.class)
				.buildSessionFactory();
		return factory;
	}

}