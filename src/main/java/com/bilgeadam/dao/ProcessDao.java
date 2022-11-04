package com.bilgeadam.dao;

import java.util.List;

import org.hibernate.Session;

import jakarta.persistence.TypedQuery;

public class ProcessDao implements IRepository<Process> {

	@Override
	public void create(Process entity) {
		Session session = null;
		try {
			session = databaseConnection();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			System.out.println("Process data is added to Db.");
		} catch (Exception e) {
			e.getMessage();
			System.err.println("Some problem occured while adding Process data.");
		}finally {
			session.close();
		}				
	
		
	}
		

	@Override
	public void update(long id, Process entity) {
		Session session = null;
		try {
			Process updateProcess = find(id);
			//updateProcess.setOperationType(entity.getOperationType());
			
	
			
			session = databaseConnection();
			session.getTransaction().begin();
			session.merge(updateProcess);
			session.getTransaction().commit();
			System.out.println("Successfully updated  Process.");
		} catch (Exception e) {
		e.printStackTrace();
		System.out.println("Some problem occured while UPDATING Process data.");
		}finally {
			session.close();
		}	
		
	}


	

	@Override
	public void delete(long id) {
Session session= null;
		
		try {
			Process deleteProcess = find(id);
			if(deleteProcess != null) {
				session = databaseConnection();
				session.getTransaction().begin();
				session.remove(deleteProcess);
				session.getTransaction().commit();
				
				System.out.println("Successfully deleted");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Some problem occured while DELETING Process data.");		
		} finally {
			session.close();
		}	
		
	}

	@Override
	public List<Process> listAll() {
		Session session = databaseConnection();
		//hibernate query language
		String hql = "select adr from Book as adr";
		
		TypedQuery<Process> typedQuery = session.createQuery(hql,Process.class);
		List<Process> processList = typedQuery.getResultList();
		
		return processList;
	}

	@Override
	public Process find(long id) {
		Process process = null;
		Session session = databaseConnection();
		
		try {
			process = session.find(Process.class, id);
			
			if(process != null) {
				System.out.println("Found Process : " + process);
			}else {
				System.out.println("Process not found");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Some problem occured while FIND Process data.");
		}finally {
			session.close();
		}
		return process;
	}


}
