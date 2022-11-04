package com.bilgeadam.dao;

import java.util.List;

import org.hibernate.Session;
import com.bilgeadam.model.Transactions;

import jakarta.persistence.TypedQuery;

public class TransactionDao implements IRepository<Transactions>{

	@Override
	public void create(Transactions entity) {
		Session session = null;
		try {
			session = databaseConnection();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			System.out.println("Transactions data is added to Db.");
		} catch (Exception e) {
			e.getMessage();
			System.err.println("Some problem occured while adding Transactions data.");
		}finally {
			session.close();
		}				
	
	}

	@Override
	public void update(long id, Transactions entity) {
		Session session = null;
		try {
			Transactions updateTransactions = find(id);
			updateTransactions.setTransactionNumber(entity.getTransactionNumber());
			updateTransactions.setOperationDate(entity.getOperationDate());
			updateTransactions.setOperationAmount(entity.getOperationAmount());
		
			
			
			session = databaseConnection();
			session.getTransaction().begin();
			session.merge(updateTransactions);
			session.getTransaction().commit();
			System.out.println("Successfully updated Transactions.");
		} catch (Exception e) {
		e.printStackTrace();
		System.out.println("Some problem occured while UPDATING Transactions data.");
		}finally {
			session.close();
		}
		
	}

	@Override
	public void delete(long id) {
Session session= null;
		
		try {
			Transactions deleteTranslations = find(id);
			if(deleteTranslations != null) {
				session = databaseConnection();
				session.getTransaction().begin();
				session.remove(deleteTranslations);
				session.getTransaction().commit();
				
				System.out.println("Successfully deleted");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Some problem occured while DELETING Translations data.");		
		} finally {
			session.close();
		}	
		
	}

	@Override
	public List<Transactions> listAll() {
		Session session = databaseConnection();
		//hibernate query language
		String hql = "select adr from Transactions as adr";
		
		TypedQuery<Transactions> typedQuery = session.createQuery(hql,Transactions.class);
		List<Transactions> userList = typedQuery.getResultList();
		
		return userList;
	}

	@Override
	public Transactions find(long id) {
		Transactions transaction = null;
		Session session = databaseConnection();
		
		try {
			transaction = session.find(Transactions.class, id);
			
			if(transaction != null) {
				System.out.println("Found transaction : " + transaction);
			}else {
				System.out.println("transaction not found");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Some problem occured while FIND transaction data.");
		}finally {
			session.close();
		}
		return transaction;
	}

}