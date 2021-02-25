package com.SpringBootFinalProject.FinalProject.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.SpringBootFinalProject.FinalProject.entities.abstracts.IEntity;

import lombok.Data;


@Data
@Entity
@Table(name="blacklist")
public class BlackList implements IEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="blacklist_id")
	private int blacklistId;
	
	@OneToOne
	private Customers customer;
	
}
