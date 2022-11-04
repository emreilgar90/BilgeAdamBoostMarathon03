package com.bilgeadam.model;

import java.time.LocalDate;
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

public class Transactions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "transaction_number", nullable = false)
	private long transactionNumber;
	@Column(name = "operation_date", nullable = false)
	private LocalDate operationDate;
	@Column(name = "operation_amount", nullable = false)
	private double operationAmount;
	@Enumerated(EnumType.STRING)
	private AccountType accountType;
	@ManyToOne
	@JoinColumn(name = "process_id", referencedColumnName = "id")
	private Process process;

}
