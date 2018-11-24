package com.julian.bella.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "EMPL_DRIVER")
public class Driver extends Employee {

	
	public String n;
	
	protected Driver() {
		super();
	}
	
	public Driver(String pesel) {
		super(pesel);
	}
	
	public Driver(String pesel, String firstName, String secondName, boolean isActive) {
		super(pesel, firstName, secondName, isActive);
	}
}
