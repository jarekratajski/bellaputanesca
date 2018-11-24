package com.julian.bella.api.dto;

public class LocationDto {

	private AddressDto address;
	private double longitude;
	private double latitude;

	public AddressDto getAddress() {
		return address;
	}

	public LocationDto setAddress(AddressDto address) {
		this.address = address;
		return this;
	}

	public double getLongitude() {
		return longitude;
	}

	public LocationDto setLongitude(double longitude) {
		this.longitude = longitude;
		return this;
	}

	public double getLatitude() {
		return latitude;
	}

	public LocationDto setLatitude(double latitude) {
		this.latitude = latitude;
		return this;
	}

}
