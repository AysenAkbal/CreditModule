package com.SpringBootFinalProject.FinalProject.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="loan_approval")
public class LoanApproval {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	private int approvalId;
	
	@Column(name = "document_name")
	private String name;
    
    @Column(name = "type")
	private String type;
	
	@Lob
    @Column(name="pic")
    private byte[] pic;
	
	@OneToOne
	private Customers customer;
	
 
}
