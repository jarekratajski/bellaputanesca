package com.julian.bella.api.dto;

import org.springframework.stereotype.Component;

@Component
public class DriverDto extends EmployeeDto {

	@Override
	public String toString() {
		return "driver: firstname: " + this.getFirstName() + " lastname: " + this.getLastName() + 
				" pesel: " + this.getPesel() + " id: " + this.getId() + " userlogin: " +
				this.getUserDto().getLogin();
	}
}
