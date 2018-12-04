package com.julian.bella.api.dto;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

public abstract class EmployeeDto {
	
	private Long id;
	private boolean isActive;
	private String pesel;
	private String firstName;
	private String lastName;

	@JsonUnwrapped
	private UserDto userDto;

	public Long getId() {
		return id;
	}
	
	public EmployeeDto setId(Long id) {
		this.id = id;
		return this;
	}
	
	public boolean isActive() {
		return isActive;
	}

	public EmployeeDto setActive(boolean isActive) {
		this.isActive = isActive;
		return this;
	}

	public String getPesel() {
		return pesel;
	}

	public EmployeeDto setPesel(String pesel) {
		this.pesel = pesel;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public EmployeeDto setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public EmployeeDto setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public UserDto getUserDto() {
		return userDto;
	}

	public EmployeeDto setUserDto(UserDto user) {
		this.userDto = user;
		return this;
	}
}
