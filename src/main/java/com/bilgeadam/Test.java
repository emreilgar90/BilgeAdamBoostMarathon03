package com.bilgeadam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.bilgeadam.dao.AccountDao;
import com.bilgeadam.dao.BranchDao;
import com.bilgeadam.dao.CustomerDao;
import com.bilgeadam.dao.ProcessDao;
import com.bilgeadam.dao.TransactionDao;
import com.bilgeadam.model.Account;
import com.bilgeadam.model.AccountType;
import com.bilgeadam.model.Branch;
import com.bilgeadam.model.Customer;
import com.bilgeadam.model.OperationType;
import com.bilgeadam.model.Process;
import com.bilgeadam.model.Transactions;

public class Test {

	public static void main(String[] args) {

		CustomerDao dao = new CustomerDao();
		BranchDao daoB1 = new BranchDao();
		ProcessDao daoP1 = new ProcessDao();
		AccountDao daoA1 = new AccountDao();
		TransactionDao daoT1 = new TransactionDao();

		List<Customer> custList = new ArrayList<Customer>();
		List<Account> accountList = new ArrayList<Account>();
		List<Transactions> transactionList = new ArrayList<Transactions>();

		custList = dao.listAll();

		for (Customer customer : custList) {
			System.out.println("Musteri No\tMusteri Adi");
			System.out
					.println(customer.getCustomerNumber() + "\t\t" + customer.getFirstName() + customer.getLastName());
			accountList = daoA1.listAll();
			for (Account account : accountList) {
				System.out.println("\t\t\tSube\t\tHesap No\tHesap Turu");
				System.out.println("\t\t\t" + account.getBranch().getBranchName() + "\t\t"
						+ account.createAccountNumber() + "\t\t" + account.getAccountType());
				transactionList = daoT1.listAll();
				for (Transactions transaction : transactionList) {

					System.out.println("\t\t\tHESAP HAREKETLERI");
					System.out.println("\t\t\tTarih\t\tIslem Kodu\tHareket\t\t\t\tIslem Bakiyesi");
					System.out.println("\t\t\t" + transaction.getOperationDate().getYear() + "-"
							+ transaction.getOperationDate().getMonthValue() + "-"
							+ transaction.getOperationDate().getDayOfMonth() + "\t" + transaction.getTransactionNumber() + "\t\t"
							+ transaction.getProcess().getOperationType() + "\t\t"
							+ "\t\t" + transaction.getOperationAmount() +" "+ transaction.getAccountType());
				}
			}
		}

		/*
		 * Customer c1 = new Customer(); c1.setFirstName("Ali"); c1.setLastName("Kara");
		 * c1.setCustomerNumber(100);
		 * 
		 * dao.create(c1);
		 * 
		 * Customer c2 = new Customer(); c2.setFirstName("Ayşe");
		 * c2.setLastName("Sarı"); c2.setCustomerNumber(101); dao.create(c2);
		 * 
		 * Branch b1 = new Branch(); b1.setBranchName("Bartin"); b1.setBranchNumber(74);
		 * 
		 * daoB1.create(b1);
		 * 
		 * Branch b2 = new Branch(); b2.setBranchName("Zonguldak");
		 * b2.setBranchNumber(67);
		 * 
		 * daoB1.create(b2);
		 * 
		 * Branch b3 = new Branch(); b3.setBranchName("Karabuk");
		 * b3.setBranchNumber(78);
		 * 
		 * daoB1.create(b3);
		 * 
		 * Process p1 = new Process(); p1.setOperationType(OperationType.INPUT);
		 * 
		 * daoP1.create(p1); Process p2 = new Process();
		 * p2.setOperationType(OperationType.OUTPUT); daoP1.create(p2);
		 * 
		 * Transactions t1 = new Transactions(); t1.setProcess(p1);
		 * t1.setTransactionNumber(100001); t1.setOperationAmount(400);
		 * t1.setOperationDate(LocalDate.of(2022, 01, 02));
		 * t1.setAccountType(AccountType.TL);
		 * 
		 * daoT1.create(t1); Transactions t2 = new Transactions(); t2.setProcess(p2);
		 * t2.setTransactionNumber(100002); t2.setOperationAmount(200);
		 * t2.setOperationDate(LocalDate.of(2022, 01, 25));
		 * t2.setAccountType(AccountType.TL); daoT1.create(t2); Transactions t3 = new
		 * Transactions(); t3.setProcess(p2); t3.setTransactionNumber(100003);
		 * t3.setOperationAmount(89); t3.setOperationDate(LocalDate.of(2022, 01, 20));
		 * t3.setAccountType(AccountType.TL); daoT1.create(t3); Transactions t4 = new
		 * Transactions(); t4.setProcess(p1); t4.setTransactionNumber(100025);
		 * t4.setOperationAmount(200); t4.setOperationDate(LocalDate.of(2022, 01, 15));
		 * t4.setAccountType(AccountType.EURO); daoT1.create(t4); Transactions t5 = new
		 * Transactions(); t5.setProcess(p2); t5.setTransactionNumber(100058);
		 * t5.setOperationAmount(100); t5.setOperationDate(LocalDate.of(2022, 02, 02));
		 * t5.setAccountType(AccountType.USD); daoT1.create(t5); Transactions t6 = new
		 * Transactions(); t6.setProcess(p1); t6.setTransactionNumber(101005);
		 * t6.setOperationAmount(200); t6.setOperationDate(LocalDate.of(2022, 01, 20));
		 * t6.setAccountType(AccountType.TL); daoT1.create(t6); Transactions t7 = new
		 * Transactions(); t7.setProcess(p2); t7.setTransactionNumber(101048);
		 * t7.setOperationAmount(115); t7.setOperationDate(LocalDate.of(2022, 01, 20));
		 * t7.setAccountType(AccountType.TL); daoT1.create(t7);
		 * 
		 * Account a1 = new Account(); a1.setAccountTypeNumber(10);
		 * a1.setAccountType(AccountType.TL); a1.setBranch(b1); a1.setCustomer(c1);
		 * 
		 * daoA1.create(a1); Account a2 = new Account (); a2.setAccountTypeNumber(11);
		 * a2.setAccountType(AccountType.EURO); a2.setBranch(b2); a2.setCustomer(c1);
		 * daoA1.create(a2); Account a3 = new Account(); a3.setAccountTypeNumber(12);
		 * a3.setAccountType(AccountType.USD); a3.setBranch(b3); a3.setCustomer(c2);
		 * daoA1.create(a3); Account a4 = new Account(); a4.setAccountTypeNumber(10);
		 * a4.setAccountType(AccountType.TL); a4.setBranch(b1); a4.setCustomer(c2);
		 * daoA1.create(a4);
		 */

	}

}
