package com.bilgeadam.dao;

import java.util.List;

import org.hibernate.Session;

import com.bilgeadam.model.Branch;
import com.bilgeadam.model.Transactions;

import jakarta.persistence.TypedQuery;

public class BranchDao implements IRepository<Branch>{

	@Override
	public void create(Branch entity) {
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
	public void update(long id, Branch entity) {
		Session session = null;
		try {
			Branch updateBranch = find(id);
			updateBranch.setBranchName(entity.getBranchName());
			updateBranch.setBranchNumber(entity.getBranchNumber());
		
			
			
			session = databaseConnection();
			session.getTransaction().begin();
			session.merge(updateBranch);
			session.getTransaction().commit();
			System.out.println("Successfully updated Branches.");
		} catch (Exception e) {
		e.printStackTrace();
		System.out.println("Some problem occured while UPDATING Branches data.");
		}finally {
			session.close();
		}	
		
	}

	@Override
	public void delete(long id) {
Session session= null;
		
		try {
			Branch deleteBranch = find(id);
			if(deleteBranch != null) {
				session = databaseConnection();
				session.getTransaction().begin();
				session.remove(deleteBranch);
				session.getTransaction().commit();
				
				System.out.println("Successfully deleteBranch");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Some problem occured while DELETING deleteBranch data.");		
		} finally {
			session.close();
		}	
		
	}

	@Override
	public List<Branch> listAll() {
		Session session = databaseConnection();
		//hibernate query language
		String hql = "select adr from Branch as adr";
		
		TypedQuery<Branch> typedQuery = session.createQuery(hql,Branch.class);
		List<Branch> branchList = typedQuery.getResultList();
		
		return branchList;
	}

	@Override
	public Branch find(long id) {
		Branch branch = null;
		Session session = databaseConnection();
		
		try {
			branch = session.find(Branch.class, id);
	
			if(branch != null) {
				System.out.println("Found branch : " + branch);
			}else {
				System.out.println(" branch not found");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Some problem occured while FIND branch data.");
		}finally {
			session.close();
		}
		return branch;
	}
}
