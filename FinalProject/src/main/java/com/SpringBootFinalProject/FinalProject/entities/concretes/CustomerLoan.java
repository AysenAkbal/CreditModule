package com.SpringBootFinalProject.FinalProject.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="loan_")
public class CustomerLoan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="loan_id")
	private int loanId;
	
	@Column(name="cust_id")
	private int custId;
	
	@Column(name="cust_loyalty")
	private int loyalty;
	
	@Column(name="subscription_year")
	private int subscriptionYear;
	
	@Column(name="legitimate_proceeding")
	private String legProoceeding;
	
	@Column(name="credit_amount")
	private int requestedCreditAmount;
	

	@Column(name="credit_date")
	private Date creditDate;
	
	@Column(name="check_amount")
	private String checkAmount;
	
	@Column(name="tc_number")
	private String tcNumber;
}
