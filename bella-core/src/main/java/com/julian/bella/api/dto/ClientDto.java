package com.julian.bella.api.dto;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

public final class ClientDto {

	private String nip;
	
	@JsonUnwrapped
	private UserDto user;
	
	private String companyName;
	
	private AddressDto contactAddress;
	private AddressDto registerAddress;



	public UserDto getUser() {
		return user;
	}

	public ClientDto setUser(UserDto userDto) {
		this.user = userDto;
		return this;
	}

	public String getNip() {
		return nip;
	}

	public ClientDto setNip(String nip) {
		this.nip = nip;
		return this;
	}

	public String getCompanyName() {
		return companyName;
	}

	public ClientDto setCompanyName(String companyName) {
		this.companyName = companyName;
		return this;
	}

	public AddressDto getContactAddress() {
		return contactAddress;
	}

	public ClientDto setContactAddress(AddressDto contactAddress) {
		this.contactAddress = contactAddress;
		return this;
	}

	public AddressDto getRegisterAddress() {
		return registerAddress;
	}

	public ClientDto setRegisterAddress(AddressDto registerAddress) {
		this.registerAddress = registerAddress;
		return this;
	}

}
