package com.julian.domain;

import java.security.NoSuchAlgorithmException;

import javax.persistence.Entity;

@Entity
public class Shipper extends Employee{

	public Shipper(String pesel, String firstName, String secondName) throws NoSuchAlgorithmException {
		super(pesel, firstName, secondName);
	}
	
}