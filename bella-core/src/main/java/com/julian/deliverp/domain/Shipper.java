package com.julian.deliverp.domain;

import javax.persistence.Entity;

@Entity
public class Shipper extends Employee{
	
	public Shipper(String pesel) {
		super(pesel);
	}

	public Shipper(String pesel, String firstName, String secondName) {
		super(pesel, firstName, secondName);
	}
	
}
