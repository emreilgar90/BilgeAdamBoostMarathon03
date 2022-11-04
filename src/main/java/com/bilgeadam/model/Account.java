package com.bilgeadam.model;

import java.util.Random;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long accountTypeNumber;
	private AccountType accountType;
	private long accountNumber;
	
	@ManyToOne
	@JoinColumn(name= "customer_id", referencedColumnName = "id")
	private Customer customer;
	@OneToOne (mappedBy = "Account")
	@JoinColumn(name="branches_id", referencedColumnName = "id")
	private Account account;

	@Column(name = "created_account_number", nullable = false)
	    public long createAccountNumber() {
		Account account = new Account();
		Customer customer = new Customer();
		Random rd = new Random();
		int n = rd.nextInt(10);
		long num = account.getAccountNumber() + customer.getCustomerNumber() + this.getAccountTypeNumber() + n ;
		return num;
		
 
		
	}
}
