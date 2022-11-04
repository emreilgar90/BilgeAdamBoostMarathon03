package com.bilgeadam.dao;

import java.util.List;

import org.hibernate.Session;

import com.bilgeadam.model.Account;

import jakarta.persistence.TypedQuery;

public class AccountDao implements IRepository<Account>{

	@Override
	public void create(Account entity) {
		Session session = null;
		try {
			session = databaseConnection();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			System.out.println("Account data is added to Db.");
		} catch (Exception e) {
			e.getMessage();
			System.err.println("Some problem occured while adding Account data.");
		}				
	}
		
	

	@Override
	public void update(long id, Account entity) {
		Session session = null;
		try {
			Account updateAccount = find(id);
			updateAccount.setAccountTypeNumber(entity.getAccountTypeNumber());
			updateAccount.setAccountType(entity.getAccountType());
			
			
			session = databaseConnection();
			session.getTransaction().begin();
			session.merge(updateAccount);
			session.getTransaction().commit();
			System.out.println("Successfully updated  updateAccount.");
		} catch (Exception e) {
		e.printStackTrace();
		System.out.println("Some problem occured while UPDATING updateAccount data.");
		}finally {
			session.close();
		}	
		
	}

	@Override
	public void delete(long id) {
Session session= null;
		
		try {
			Account deleteAccount = find(id);
			if( deleteAccount!= null) {
				session = databaseConnection();
				session.getTransaction().begin();
				session.remove(deleteAccount);
				session.getTransaction().commit();
				
				System.out.println("Successfully deleted");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Some problem occured while DELETING Account data.");		
		} finally {
			session.close();
		}	
		
	}

	@Override
	public List<Account> listAll() {
		Session session = databaseConnection();
		//hibernate query language
		String hql = "select adr from Account as adr";
		
		TypedQuery<Account> typedQuery = session.createQuery(hql,Account.class);
		List<Account> accountList = typedQuery.getResultList();
		
		return accountList ;
	}

	@Override
	public Account find(long id) {
Account account = null;
		Session session = databaseConnection();
		
		try {
			account  = session.find(Account.class, id);
			
			if(account  != null) {
				System.out.println("Found Book : " + account );
			}else {
				System.out.println("account  not found");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Some problem occured while FIND account  data.");
		}finally {
			session.close();
		}
		return account ;
	}

}
