package com.julian.deliverp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.pl.PESEL;

import com.julian.deliverp.rodo.HashMD5;

@Entity
public abstract class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@PESEL
	@Transient
	private final String pesel; // TODO encrypt and validate

	@Column(unique = true, updatable = false)
	public final String peselEncrypted; // TODO encrypt and validate

	private String firstName;
	private String secondName;

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

	public Employee(String pesel, String firstName, String secondName) {
		this.pesel = pesel;
		this.firstName = firstName;
		this.secondName = secondName;
		this.peselEncrypted = HashMD5.getHashed(pesel);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
