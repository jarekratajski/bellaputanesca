package com.julian.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.DecimalMin;

import com.julian.validation.VinConstraint;

@Entity
public class Vehicle {

	@Id
	@VinConstraint
	@Column(length = 17, unique = true, updatable = false)
	public final String vin; // Vehicle Identification Number

	@DecimalMin(value = "0.0")
	private int mileageKm;

	@DecimalMin(value = "0.0")
	private double capacityKg;

	private LocalDate purchaseDate;

	@OneToOne
	private Driver driver;

	/**
	 * Arguments of the class are immutable but JPA always needs a default
	 * constructor. Documentation of the Hibernate says: "The entity class must have
	 * a public or protected no-argument constructor."
	 */
	protected Vehicle() {
		this.vin = null;
	}

	public Vehicle(String vin) {
		this.vin = vin;
	}

	public String getVin() {
		return vin;
	}

	public int getMileage() {
		return mileageKm;
	}

	public void incrementMileage(int kmToAdd) {
		mileageKm += kmToAdd;
	}

	public double getCapacity() {
		return capacityKg;
	}

	public void setCapacity(double capacityKg) {
		this.capacityKg = capacityKg;
	}

	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

}