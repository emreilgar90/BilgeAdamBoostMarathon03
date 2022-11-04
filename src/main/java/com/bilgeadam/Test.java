package com.bilgeadam;

import com.bilgeadam.dao.AccountDao;
import com.bilgeadam.dao.BranchDao;
import com.bilgeadam.dao.CustomerDao;
import com.bilgeadam.model.Account;
import com.bilgeadam.model.AccountNumber;
import com.bilgeadam.model.AccountType;
import com.bilgeadam.model.Branch;
import com.bilgeadam.model.Customer;

public class Test {
public static void main(String[] args) {

		// TODO Auto-generated method stub
		//HibernateSession.getSessionFactory().openSession();
		Customer c1 = new Customer();
		c1.setLastName("Ali");
		c1.setLastName("Kara");
		CustomerDao dao = new CustomerDao();
		dao.create(c1);
		
		Customer c2 = new Customer();
		c2.setLastName("Ayşe");
		c2.setLastName("Sarı");
		CustomerDao dao1 = new CustomerDao();
		dao1.create(c2);
		
		
		Branch b1 = new Branch();
		b1.setBranchName("Bartin");
		b1.setBranchNumber(74);
		BranchDao daoB1 = new BranchDao();
		daoB1.create(b1);
		
		Branch b2 = new Branch();
		b2.setBranchName("Zonguldak");
		b2.setBranchNumber(67);
		BranchDao daoB2 = new BranchDao();
		daoB2.create(b2);
		
		Branch b3 = new Branch();
		b3.setBranchName("Karabuk");
		b3.setBranchNumber(78);
		BranchDao daoB3 = new BranchDao();
		daoB3.create(b3);
		
		Account a1 = new Account();
		a1.setAccountNumber(10);
		a1.setAccountTypeNumber(0);
		a1.setAccountType(AccountType.TL);
		AccountDao daoA1 = new AccountDao();
		daoA1.create(a1);
		
		
		
		BankService ls = new BankService();
		HashMap<Integer,String> map = new HashMap<>();
		map.put(1, "Borrow Book");
		map.put(2, "Return Book");
		int key = BAUtils.menu(map);
		
		switch (key) {
		case 1:
		 System.out.println(bookDao.listAll());	;
		 Scanner sc = new Scanner(System.in);
		 int temp = sc.nextInt();
		//bookDao.find(temp);
			ls.borrowBook(bookDao.find(temp),student);
			break;
			
		case 2:
			
			ls.returnBook(book, student);
		default:
			break;
		}
//		ls.borrowBook(book, student);	
//		ls.returnBook(book, student);
	}

}
