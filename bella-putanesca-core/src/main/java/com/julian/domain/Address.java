package com.julian.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "city", "street", "houseNumberEtc", "postalcode" }))
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(updatable = false)
	public final String city;

	@Column(updatable = false)
	public final String street;

	@Column(updatable = false)
	public final String houseNumberEtc;

	@Pattern(regexp = "^\\d{2}-\\d{3}$")
	@Column(updatable = false)
	public final String postalCode;
	
	@OneToOne(mappedBy="address")
	private Location area;

	/**
	 * Arguments of the class are immutable but JPA always needs a default
	 * constructor. Documentation of the Hibernate says: "The entity class must have
	 * a public or protected no-argument constructor."
	 */
	protected Address() {
		this.city = null;
		this.street = null;
		this.houseNumberEtc = null;
		this.postalCode = null;
	}

	public Address(String city, String street, String houseNumberEtc, String postalCode) {
		this.city = city;
		this.street = street;
		this.houseNumberEtc = houseNumberEtc;
		this.postalCode = postalCode;
	}

	public Long getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "Address [" + city + street + houseNumberEtc + postalCode + "]";
	}
}