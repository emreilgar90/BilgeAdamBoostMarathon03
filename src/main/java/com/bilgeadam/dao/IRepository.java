package com.bilgeadam.dao;

import java.util.List;

import org.hibernate.Session;

import com.bilgeadam.util.HibernateSession;

public interface IRepository<T> {
	 

		public void create(T entity);
		
		public void update(long id, T entity);
		
		public void delete(long id);
		
		List<T> listAll();
		
		T find(long id);
		
		default Session databaseConnection() {
			return HibernateSession.getSessionFactory().openSession();
		}
		
	}



imp