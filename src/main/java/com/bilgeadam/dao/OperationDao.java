package com.bilgeadam.dao;

import java.util.List;

import org.hibernate.Session;

import com.bilgeadam.model.Customer;
import com.bilgeadam.model.Operation;

import jakarta.persistence.TypedQuery;

public class OperationDao implements IRepository<Operation>{

	@Override
	public void create(Operation entity) {
		Session session = null;
		try {
			session = databaseConnection();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			System.out.println("Operation data is added to Db.");
		} catch (Exception e) {
			e.getMessage();
			System.err.println("Some problem occured while adding operation data.");
		}finally {
			session.close();
		}				
	}
		
	

	@Override
	public void update(long id, Operation entity) {
		Session session = null;
		try {
			Operation updateOperation = find(id);
			updateOperation.setOperationType(entity.getOperationType());
			
			
			session = databaseConnection();
			session.getTransaction().begin();
			session.merge(updateOperation);
			session.getTransaction().commit();
			System.out.println("Successfully updated Operation.");
		} catch (Exception e) {
		e.printStackTrace();
		System.out.println("Some problem occured while UPDATING operation data.");
		}finally {
			session.close();
		}	
		
	}

	@Override
	public void delete(long id) {
Session session= null;
		
		try {
			Operation deleteOperation = find(id);
			if(deleteOperation != null) {
				session = databaseConnection();
				session.getTransaction().begin();
				session.remove(deleteOperation);
				session.getTransaction().commit();
				
				System.out.println("Successfully deleted");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Some problem occured while DELETING Operation data.");		
		} finally {
			session.close();
		}	
		
	}

	@Override
	public List<Operation> listAll() {
		Session session = databaseConnection();
		//hibernate query language
		String hql = "select adr from Book as adr";
		
		TypedQuery<Operation> typedQuery = session.createQuery(hql,Operation.class);
		List<Operation> operationList = typedQuery.getResultList();
		
		return operationList;
	}

	@Override
	public Operation find(long id) {
		Operation operation = null;
		Session session = databaseConnection();
		
		try {
			operation = session.find(Operation.class, id);
			
			if(operation != null) {
				System.out.println("Found operation : " + operation);
			}else {
				System.out.println("operation not found");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Some problem occured while FIND operation data.");
		}finally {
			session.close();
		}
		return operation;
	}

}
