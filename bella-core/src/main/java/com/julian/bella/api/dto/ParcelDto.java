package com.julian.bella.api.dto;

import com.julian.bella.domain.ParcelType;

public class ParcelDto {

	private Long id;
	private ParcelType type;
	private double weightKg;
	private double sizeDm3;
	private boolean isFragile;
	private String description;

	public Long getId() {
		return id;
	}

	public ParcelDto setId(Long id) {
		this.id = id;
		return this;
	}

	public ParcelType getType() {
		return type;
	}

	public ParcelDto setType(ParcelType type) {
		this.type = type;
		return this;
	}

	public double getWeightKg() {
		return weightKg;
	}

	public ParcelDto setWeightKg(double weightKg) {
		this.weightKg = weightKg;
		return this;
	}

	public double getSizeDm3() {
		return sizeDm3;
	}

	public ParcelDto setSizeDm3(double sizeDm3) {
		this.sizeDm3 = sizeDm3;
		return this;
	}

	public boolean isFragile() {
		return isFragile;
	}

	public ParcelDto setFragile(boolean isFragile) {
		this.isFragile = isFragile;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public ParcelDto setDescription(String description) {
		this.description = description;
		return this;
	}
}
