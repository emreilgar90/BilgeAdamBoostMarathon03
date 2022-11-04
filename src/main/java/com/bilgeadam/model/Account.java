package com.bilgeadam.model;

import java.util.Random;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	@Column(name = "account_type_number")
	private long accountTypeNumber;
	@Enumerated(EnumType.STRING)
	private AccountType accountType;

	@ManyToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	private Customer customer;
	@ManyToOne
	@JoinColumn(name = "branches_id", referencedColumnName = "id")
	private Branch branch;

	public String createAccountNumber() {
		Customer customer = new Customer();
		Random rd = new Random();
		int n = rd.nextInt(10);
		String num = customer.getCustomerNumber() + "" + this.getAccountTypeNumber() + "" + n;
		return num;
	}
}
