package com.julian.domain;

import static org.junit.Assert.assertEquals;

import java.security.NoSuchAlgorithmException;

import org.junit.Test;

public class ConstraintsConstructorPeselTest extends ConstraintsTest {
	
	@Test
	public void testPeselEmployeeValid() throws NoSuchAlgorithmException {
		// given
		boolean isValidExpected = true;
		String validPesel = "94092367705";

		// when
		Employee employeeValid = new Driver(validPesel);

		// then
		super.testConstructorArgs(employeeValid, isValidExpected);
		assertEquals(validPesel, employeeValid.getPesel());
	}

	@Test
	public void testPeselEmployeeInvalid() throws NoSuchAlgorithmException {
		// given
		boolean isValidExpected = false;

		// when
		Employee employeeInvalid0 = new Driver("1");
		Employee employeeInvalid1 = new Driver("9409236770 ");
		Employee employeeInvalid2 = new Driver("94092367704");
		Employee employeeInvalid3 = new Driver("9a092367705");

		// then
		super.testConstructorArgs(employeeInvalid0, isValidExpected);
		super.testConstructorArgs(employeeInvalid1, isValidExpected);
		super.testConstructorArgs(employeeInvalid2, isValidExpected);
		super.testConstructorArgs(employeeInvalid3, isValidExpected);
	}

}