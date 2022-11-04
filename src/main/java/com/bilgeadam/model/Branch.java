package com.bilgeadam.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table
@Entity
public class Branch {

			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			private long id;
			@Column(name = "branch_number", nullable = false)
			private long branchNumber;
			@Column(name = "branch_name", nullable = false)
			private String branchName;
			@OneToOne(cascade = CascadeType.ALL)
			private Account account;
			


}
