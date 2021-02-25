package com.SpringBootFinalProject.FinalProject.dataaccess.concretes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.SpringBootFinalProject.FinalProject.entities.concretes.Customers;

public interface CustomerRepository extends JpaRepository<Customers, Integer>{

	@Query(value="SELECT * from turkcell_customers where tc_number=?1",nativeQuery= true)
	List<Customers> findEquality(String custId);
	
	@Query(value = "select tc_number from turkcell_customers where id > 0",nativeQuery= true)
	List<String> findTcNumber();
	
	@Query(value="select salary from turkcell_customers where id=?1", nativeQuery= true)
	int getSalary(Integer custId);

}
