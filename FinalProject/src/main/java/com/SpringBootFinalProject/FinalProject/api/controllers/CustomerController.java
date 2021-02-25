package com.SpringBootFinalProject.FinalProject.api.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootFinalProject.FinalProject.business.abstracts.ICustomerService;
import com.SpringBootFinalProject.FinalProject.entities.concretes.Customers;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {

	@Autowired
	ICustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customers> getAll(){
		
		return customerService.getAll();
	}
	@PostMapping("/customers")
	public Customers add(@RequestBody Customers customer) throws IOException {
		
		return customerService.addCustomer(customer);
	}
}
