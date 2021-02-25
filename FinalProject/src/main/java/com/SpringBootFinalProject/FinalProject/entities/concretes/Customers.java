package com.SpringBootFinalProject.FinalProject.entities.concretes;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.SpringBootFinalProject.FinalProject.entities.abstracts.IEntity;

import lombok.Data;

@Data
@Entity
@Table(name="turkcell_customers")
public class Customers implements IEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="tc_number")
	private String tcNumber;
	@Column(name="name")
	private String customerName;
	@Column(name="surname")
	private String surname;
	@Column(name="birthdate")
	private String birthdate;
	@Column(name="msisdn")
	private String gsmNo;
	@Column(name="address")
	private String address;
	@Column(name="customer_type")
	private String customerType;
	@Column(name="subscription_date")
	private String subsDate;

	@Column(name="salary")
	private int salary;

	@Column(name="pic_name")
	private String pictureName;
	
	@Lob
    @Column(name="pic")
    private byte[] pic;
	
	@Column(name="pic_type")
	private String pictureType;
	
	
	
}
