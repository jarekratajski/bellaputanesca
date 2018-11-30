package com.julian.bella.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Shipper extends Employee{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	public Shipper() {
		super();
	}
	
	public Shipper(String pesel) {
		super(pesel);
	}

	public Shipper(String pesel, String firstName, String secondName, boolean isActive) {
		super(pesel, firstName, secondName, isActive);
	}
	
	public Long getId() {
		return id;
	}
	
}
