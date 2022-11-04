package com.bilgeadam.dao;

import java.util.List;

import org.hibernate.Session;

import com.bilgeadam.model.Customer;
import jakarta.persistence.TypedQuery;


public class CustomerDao implements IRepository<Customer> {

	@Override
	public void create(Customer entity) {
		Session session = null;
		try {
			session = databaseConnection();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			System.out.println("Book data is added to Db.");
		} catch (Exception e) {
			e.getMessage();
			System.err.println("Some problem occured while adding Book data.");
		}finally {
			session.close();
		}				
	}
		
	

	@Override
	public void update(long id, Customer entity) {
		Session session = null;
		try {
			Customer updateCustomer = find(id);
			updateCustomer.setFirstName(entity.getFirstName());
			updateCustomer.setLastName(entity.getLastName());
			updateCustomer.setCustomerNumber(entity.getCustomerNumber());
		
			
			
			session = databaseConnection();
			session.getTransaction().begin();
			session.merge(updateCustomer);
			session.getTransaction().commit();
			System.out.println("Successfully updated Customer.");
		} catch (Exception e) {
		e.printStackTrace();
		System.out.println("Some problem occured while UPDATING Customer data.");
		}finally {
			session.close();
		}	
		
	}

	@Override
	public void delete(long id) {
Session session= null;
		
		try {
			Customer deleteCustomer = find(id);
			if(deleteCustomer != null) {
				session = databaseConnection();
				session.getTransaction().begin();
				session.remove(deleteCustomer);
				session.getTransaction().commit();
				
				System.out.println("Successfully deleted");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Some problem occured while DELETING Customer data.");		
		} finally {
			session.close();
		}	
		
	}

	@Override
	public List<Customer> listAll() {
		Session session = databaseConnection();
		//hibernate query language
		String hql = "select adr from Customer as adr";
		
		TypedQuery<Customer> typedQuery = session.createQuery(hql,Customer.class);
		List<Customer> customerList = typedQuery.getResultList();
		
		return customerList;
	}

	@Override
	public Customer find(long id) {
		Customer customer = null;
		Session session = databaseConnection();
		
		try {
			customer = session.find(Customer.class, id);
			
			if(customer != null) {
				System.out.println("Found customer : " +customer);
			}else {
				System.out.println("customer not found");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Some problem occured while FIND customer data.");
		}finally {
			session.close();
		}
		return customer;
	}

}
