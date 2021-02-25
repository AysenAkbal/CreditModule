package com.SpringBootFinalProject.FinalProject.business.abstracts;

import java.util.List;

import com.SpringBootFinalProject.FinalProject.entities.concretes.CustomerLoan;

public interface ICustomerLoanService {

	List<CustomerLoan> getAll();
	CustomerLoan enteredCredit(CustomerLoan customerloan) throws Exception;
	CustomerLoan checkCredit(CustomerLoan customerloan);
}
