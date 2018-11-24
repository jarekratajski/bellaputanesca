package com.julian.bella.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.hibernate.validator.internal.constraintvalidators.hv.pl.PESELValidator;
import org.junit.Before;
import org.junit.Test;

import com.julian.bella.domain.Driver;
import com.julian.bella.domain.Employee;

public class ConstraintsConstructorPeselTest extends ConstraintsTests {
	
	PESELValidator peselValidator;
	
	@Before
	public void onStart2() {
		this.peselValidator = new PESELValidator();
		peselValidator.initialize(null);
	}
	
	
	@Test
	public void testPeselEmployeeValid() {
		// given
		boolean isValidExpected = true;
		String validPesel = "94092367705";

		// when
		Employee employeeValid = new Driver(validPesel);

		// then
		assertTrue(peselValidator.isValid(validPesel, null));
		super.testConstructorArgs(isValidExpected, employeeValid);
	}

	@Test
	public void testPeselEmployeeInvalid() {
		// given
		boolean isValidExpected = false;
		String invalidPesel0 = "1";
		String invalidPesel1 = "9409236770 ";
		String invalidPesel2 = "94092367704";
		String invalidPesel3 = "9a092367705";

		// when
		Employee employeeInvalid0 = new Driver(invalidPesel0);
		Employee employeeInvalid1 = new Driver(invalidPesel1);
		Employee employeeInvalid2 = new Driver(invalidPesel2);
		Employee employeeInvalid3 = new Driver(invalidPesel3);

		// then
		assertEquals(isValidExpected, peselValidator.isValid(invalidPesel0, null));
		assertEquals(isValidExpected, peselValidator.isValid(invalidPesel1, null));
		assertEquals(isValidExpected, peselValidator.isValid(invalidPesel2, null));
		assertEquals(isValidExpected, peselValidator.isValid(invalidPesel3, null));
		super.testConstructorArgs(isValidExpected, employeeInvalid0);
		super.testConstructorArgs(isValidExpected, employeeInvalid1);
		super.testConstructorArgs(isValidExpected, employeeInvalid2);
		super.testConstructorArgs(isValidExpected, employeeInvalid3);
	}
	

}
