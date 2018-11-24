package com.julian.bella.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "EMPL_CALL_CENTER_CONSULTANT")
public class CallCenterConsultant extends Employee {

	protected CallCenterConsultant() {
		super();
	}

	public CallCenterConsultant(String pesel) {
		super(pesel);
	}

	public CallCenterConsultant(String pesel, String firstName, String secondName, boolean isActive) {
		super(pesel, firstName, secondName, isActive);
	}
}
