package com.julian.bella.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "EMPL_SHIPPER")
public class Shipper extends Employee{
	
	public Shipper() {
		super();
	}
	
	public Shipper(String pesel) {
		super(pesel);
	}

	public Shipper(String pesel, String firstName, String secondName, boolean isActive) {
		super(pesel, firstName, secondName, isActive);
	}
	
}
