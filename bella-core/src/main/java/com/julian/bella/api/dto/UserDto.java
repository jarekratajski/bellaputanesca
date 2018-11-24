package com.julian.bella.api.dto;

import org.springframework.stereotype.Component;

@Component
public class UserDto {

	private String login;
	private String email;

	public String getLogin() {
		return login;
	}

	public UserDto setLogin(String login) {
		this.login = login;
		return this;
	}
	
	public String getEmail() {
		return email;
	}
	
	public UserDto setEmail(String email) {
		this.email = email;
		return this;
	}
}
