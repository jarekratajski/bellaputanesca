package com.julian.deliverp.api.dto;

import org.springframework.stereotype.Component;

@Component
public class UserDto {

	private String login;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

}
