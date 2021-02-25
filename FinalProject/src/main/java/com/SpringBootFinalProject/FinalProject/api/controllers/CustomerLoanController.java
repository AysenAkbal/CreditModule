package com.SpringBootFinalProject.FinalProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootFinalProject.FinalProject.business.abstracts.ICustomerLoanService;
import com.SpringBootFinalProject.FinalProject.entities.concretes.CustomerLoan;

@RestController
@RequestMapping("/api/v1")
public class CustomerLoanController {

	@Autowired
	ICustomerLoanService customerloanService;
	
	@GetMapping("/customerloan")
	public List<CustomerLoan> getAll(){
		
		return customerloanService.getAll();
	}
	
	@PostMapping("/customerloan")
	public CustomerLoan addCredit(@RequestBody CustomerLoan customerloan) throws Exception {
		
		return customerloanService.enteredCredit(customerloan);
		
	}
	
	@PutMapping("/customerloan/{loan_id}")
	public CustomerLoan checkedAmount(@PathVariable(value ="loan_id") CustomerLoan customerloan) {
		
		return customerloanService.checkCredit(customerloan);
	}
}
