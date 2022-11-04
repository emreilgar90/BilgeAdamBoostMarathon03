package com.bilgeadam.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bilgeadam.model.*;
import com.bilgeadam.model.Process;


public class HibernateSession {
	
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {	
		
		if(HibernateSession.sessionFactory == null ) {	
			HibernateSession.sessionFactory = createSessionFactory();
			}
		return HibernateSession.sessionFactory;
		
		
	}
	private static SessionFactory createSessionFactory() {
		Configuration conf = new Configuration();	
		
		//Entity'leri configration'a ekliyoruz.
		conf.addAnnotatedClass(Customer.class);
		conf.addAnnotatedClass(Account.class);
		conf.addAnnotatedClass(Process.class);
		conf.addAnnotatedClass(Transactions.class);
		conf.addAnnotatedClass(Branch.class);
		
		
		SessionFactory sessionFactory = conf.configure("hibernate.cfg.xml").buildSessionFactory();
		System.out.println("Connection to PostgreSQL via Hibernate is successful.");
		return sessionFactory;
	}
	
	
}
