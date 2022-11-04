package com.bilgeadam.services;

import java.time.LocalDate;

import com.bilgeadam.dao.AccountDao;
import com.bilgeadam.dao.BranchDao;
import com.bilgeadam.dao.CustomerDao;
import com.bilgeadam.dao.OperationDao;
import com.bilgeadam.dao.ProcessDao;
import com.bilgeadam.dao.TransactionDao;
import com.bilgeadam.model.Account;
import com.bilgeadam.model.Branch;
import com.bilgeadam.model.Customer;


	public class BankService {

	AccountDao accountDao = new AccountDao();
	BranchDao branchDao = new BranchDao();
	CustomerDao customerDao = new CustomerDao();
	OperationDao operationDao = new OperationDao();
	ProcessDao processDao = new ProcessDao();
	TransactionDao transactionDao = new TransactionDao();


	public void inputTransactions(Customer customer, Account account, Branch branch) {
		customer.g
		
		}
	
	public void outputTransactions() {
		
		
	}
	
	
	public void borrowBook(Book book, Student student) {
			book.getBookDetail().setBookBorrowDate(LocalDate.now());
			book.getBookDetail().setBookReturnDate(LocalDate.now().plusDays(30));
			book.getBookDetail().setBorrowed(true);
			book.setActiveStudent(student);
			
			student.getBookList().add(book);
			
			bookDao.update(book.getId(), book);
			stuDao.update(student.getId(), student);
			System.out.println(book.getTitle() + " is borrowed by" + student.getUsername());
		}

	public void returnBook(Book book, Student student) {
		book.getBookDetail().setBookBorrowDate(null);
		book.getBookDetail().setBookReturnDate(null);
		book.getBookDetail().setBorrowed(false);
		book.setActiveStudent(null);

		student.getBookList().remove(book);

		bookDao.update(book.getId(), book);
		stuDao.update(student.getId(), student);
		System.out.println(book.getTitle() + " is returned by" + student.getUsername());

	}

}

}
