package com.julian.bella.api.dto;

import java.time.LocalDate;

public class VehicleDto {

	private String vin;
	private int mileageKm;
	private double capacityKg;
	private LocalDate purchaseDate;
	private DriverDto driver;

	public String getVin() {
		return vin;
	}

	public VehicleDto setVin(String vin) {
		this.vin = vin;
		return this;
	}

	public int getMileageKm() {
		return mileageKm;
	}

	public VehicleDto setMileageKm(int mileageKm) {
		this.mileageKm = mileageKm;
		return this;
	}

	public double getCapacityKg() {
		return capacityKg;
	}

	public VehicleDto setCapacityKg(double capacityKg) {
		this.capacityKg = capacityKg;
		return this;
	}

	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	public VehicleDto setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
		return this;
	}

	public DriverDto getDriverDto() {
		return driver;
	}

	public VehicleDto setDriverDto(DriverDto driverDto) {
		this.driver = driverDto;
		return this;
	}

}
