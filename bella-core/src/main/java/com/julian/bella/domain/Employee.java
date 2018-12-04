package com.julian.bella.domain;

import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.pl.PESEL;

import com.julian.bella.rodo.HashMD5;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Employee {

	private boolean isActive;

	@PESEL
	@Transient
	private final String pesel; // TODO encrypt and validate

	@Column(unique = true, updatable = false)
	public final String peselEncrypted; // TODO encrypt and validate

	private String firstName;
	private String lastName;

	@OneToOne
	private User user;

	/**
	 * Arguments of the class are immutable but JPA always needs a default
	 * constructor. Documentation of the Hibernate says: "The entity class must have
	 * a public or protected no-argument constructor."
	 */
	protected Employee() {
		this.pesel = null;
		this.peselEncrypted = null;
	}

	public Employee(String pesel) {
		this.pesel = pesel;
		this.peselEncrypted = HashMD5.getHashed(pesel);
	}

	public Employee(String pesel, String firstName, String secondName, boolean isActive) {
		this.pesel = pesel;
		this.firstName = firstName;
		this.lastName = secondName;
		this.peselEncrypted = HashMD5.getHashed(pesel);
		this.isActive = isActive;
	}
	
	public boolean isActive() {
		return isActive;
	}
	
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String secondName) {
		this.lastName = secondName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
