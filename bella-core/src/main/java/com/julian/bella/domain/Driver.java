package com.julian.bella.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Driver extends Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	protected Driver() {
		super();
	}

	public Driver(String pesel) {
		super(pesel);
	}

	public Driver(String pesel, String firstName, String secondName, boolean isActive) {
		super(pesel, firstName, secondName, isActive);
	}

	public Long getId() {
		return id;
	}
}
