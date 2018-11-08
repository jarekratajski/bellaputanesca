package com.julian.deliverp.domain;

import javax.persistence.Entity;

@Entity
public class Driver extends Employee {


	protected Driver() {
		super();
	}
	
	public Driver(String pesel) {
		super(pesel);
	}
	
	public Driver(String pesel, String firstName, String secondName) {
		super(pesel, firstName, secondName);
	}
}
