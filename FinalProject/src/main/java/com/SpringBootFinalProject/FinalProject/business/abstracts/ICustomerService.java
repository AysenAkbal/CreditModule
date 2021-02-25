package com.SpringBootFinalProject.FinalProject.business.abstracts;

import java.io.IOException;
import java.util.List;

import com.SpringBootFinalProject.FinalProject.entities.concretes.Customers;

public interface ICustomerService {

	List<Customers> getAll();
	Customers addCustomer (Customers customer) throws IOException;
	
}
