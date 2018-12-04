package com.julian.bella.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.validation.constraints.Email;

import com.julian.bella.rodo.UserRole;

@Entity
public class User {

	@Id
	private String login;
	
	@Email
	private String email;
	
	private boolean isActive;
		
	@Enumerated(EnumType.STRING)
	private UserRole userRole;

	public String getLogin() {
		return login;
	}

	public User setLogin(String login) {
		this.login = login;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public User setEmail(String email) {
		this.email = email;
		return this;
	}	
	
	public boolean isActive() {
		return isActive;
	}
	
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public User setUserRole(UserRole userRole) {
		this.userRole = userRole;
		return this;
	}	
	
	
}
