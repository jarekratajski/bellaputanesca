package com.julian.bella.api.dto;

public class AddressDto {

	private String city;
	private String street;
	private String houseNumberEtc;
	private String postalCode;

	public String getCity() {
		return city;
	}

	public AddressDto setCity(String city) {
		this.city = city;
		return this;
	}

	public String getStreet() {
		return street;
	}

	public AddressDto setStreet(String street) {
		this.street = street;
		return this;
	}

	public String getHouseNumberEtc() {
		return houseNumberEtc;
	}

	public AddressDto setHouseNumberEtc(String houseNumberEtc) {
		this.houseNumberEtc = houseNumberEtc;
		return this;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public AddressDto setPostalCode(String postalCode) {
		this.postalCode = postalCode;
		return this;
	}

}
