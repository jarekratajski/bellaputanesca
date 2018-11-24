package com.julian.bella.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

import org.hibernate.annotations.Immutable;

/**
 * 
 * Client can make orders only between locations which are listed in database.
 * 
 * This class should be final but JPA does not allow the entities class to be
 * final. Documentation of the Hibernate says: "The entity class must not be
 * final.", "The entity class must be a top-level class."
 */

@Entity
@Immutable
public class Location {

	@Id
	@Column(name = "address_id", updatable = false)
	public final Long id;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	public final Address address;

	@DecimalMax(value = "180.0")
	@DecimalMin(value = "-180.0")
	@Column(updatable = false)
	public final double longitude;

	@DecimalMax(value = "90.0")
	@DecimalMin(value = "-90.0")
	@Column(updatable = false)
	public final double latitude;

	/**
	 * Arguments of the class are immutable but JPA always needs a default
	 * constructor. Documentation of the Hibernate says: "The entity class must have
	 * a public or protected no-argument constructor."
	 */
	protected Location() {
		this.id = 0L;
		this.address = null;
		this.longitude = 0;
		this.latitude = 0;
	}

	public Location(Address address, double longitude, double latitude) {
		this.id = address.getId();
		this.address = address;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	@Override
	public String toString() {
		return address.toString();
	}
}
