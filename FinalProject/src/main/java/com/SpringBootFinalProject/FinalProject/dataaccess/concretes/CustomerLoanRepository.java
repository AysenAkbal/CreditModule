package com.SpringBootFinalProject.FinalProject.dataaccess.concretes;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.SpringBootFinalProject.FinalProject.entities.concretes.CustomerLoan;

public interface CustomerLoanRepository  extends JpaRepository<CustomerLoan, Integer>{

	//son cekilen kredi uzerinden kac gun gecmis ? min 30 olmali
	@Query(value="SELECT max(credit_date) from loan_ where cust_id =?1", nativeQuery= true)
	Date checkNumberOfCredit(Integer custId);
	
	//1 yilda toplam cekilen kredi miktari
	@Query(value="select coalesce(sum(credit_amount),0) from loan_ where cust_id =?1 and date_part('year',CREDIT_DATE) ='2021'", nativeQuery= true)
	Integer checkAmount(Integer loanId);
	
	@Modifying
	@Query(value="UPDATE loan_ SET check_amount=?1 WHERE loan_id=?2", nativeQuery= true)
	void confirmOrNot(String checkAmount,Integer loanId);
	
}
