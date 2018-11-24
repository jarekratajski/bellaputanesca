package com.julian.bella.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.julian.bella.rodo.UserRole;

@Entity
public class User {

	@Id
	@GeneratedValue
	private Long id;
	private boolean isActive;
	
	@NotBlank
	@Column(unique=true)
	private String login;
	
	@Email
	private String email;
	
	@Enumerated(EnumType.STRING)
	private UserRole userRole;

	public Long getId() {
		return id;
	}
	
	public boolean isActive() {
		return isActive;
	}
	
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

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

	public UserRole getUserRole() {
		return userRole;
	}

	public User setUserRole(UserRole userRole) {
		this.userRole = userRole;
		return this;
	}	
}
