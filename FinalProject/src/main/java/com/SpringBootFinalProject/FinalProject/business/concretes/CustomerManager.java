package com.SpringBootFinalProject.FinalProject.business.concretes;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.SpringBootFinalProject.FinalProject.business.abstracts.ICustomerService;
import com.SpringBootFinalProject.FinalProject.dataaccess.concretes.CustomerRepository;
import com.SpringBootFinalProject.FinalProject.entities.concretes.Customers;

@Service
public class CustomerManager implements ICustomerService {

	@Autowired
	CustomerRepository customerRepo;
	
	@Override
	public List<Customers> getAll() {
		
		return customerRepo.findAll();
	}
	
	@Override
	public Customers addCustomer(Customers customer) throws IOException {
		
		String tcNumber = customer.getTcNumber();
		List<Customers> list = customerRepo.findEquality(tcNumber);
		
		if(!list.isEmpty()) {
			
			throw new FileAlreadyExistsException("Eklenmek istenen kullanıcı sistemde mevcuttur.");
			
		}else {
			
			ClassPathResource jsaCoverImgFile = new ClassPathResource("files/nehir_kimlik.png");
			byte[] arrayData = new byte[(int) jsaCoverImgFile.contentLength()];
			jsaCoverImgFile.getInputStream().read(arrayData);
			customer.setPictureName("user_register");
			customer.setPictureType("jpg");
			customer.setPic(arrayData);
			
			// store files to PostgreSQL via SpringJPA
			customerRepo.saveAll(Arrays.asList(customer));
			
			return customerRepo.save(customer);
		}
				
	}
	
	

}
