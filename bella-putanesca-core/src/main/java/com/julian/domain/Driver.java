package com.julian.domain;

import java.security.NoSuchAlgorithmException;

import javax.persistence.Entity;

@Entity
public class Driver extends Employee {


	protected Driver() {
		super();
	}
	
	public Driver(String pesel) throws NoSuchAlgorithmException {
		super(pesel);
	}
	
	public Driver(String pesel, String firstName, String secondName) throws NoSuchAlgorithmException {
		super(pesel, firstName, secondName);
	}
}