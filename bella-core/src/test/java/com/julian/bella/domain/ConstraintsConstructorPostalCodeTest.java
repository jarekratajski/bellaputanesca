package com.julian.bella.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.julian.bella.domain.Address;

public class ConstraintsConstructorPostalCodeTest extends ConstraintsTests {

	@Test
	public void testPostalCodeAddressValid() {
		// given
		boolean isValidExpected = true;
		String validPostalCode = "01-225";
		
		// when
		Address addressValid = new Address("Wielka WARSZAAAAAAWA", "Kasprzaka", "1/1", validPostalCode);

		// then
		super.testConstructorArgs(isValidExpected, addressValid);
		assertEquals(validPostalCode, addressValid.postalCode);
	}
	
	@Test
	public void testPostalCodeAddressInvalid() {
		// given
		boolean isValidExpected = false;
		String invalidPostalCode0 = "1";
		String invalidPostalCode1 = "01-22 ";
		String invalidPostalCode2 = "01225";	
		
		// when
		Address addressInvalid0 = new Address("Wielka WARSZAAAAAAWA", "Kasprzaka", "1/1", invalidPostalCode0);
		Address addressInvalid1 = new Address("Wielka WARSZAAAAAAWA", "Kasprzaka", "1/1", invalidPostalCode1);
		Address addressInvalid2 = new Address("Wielka WARSZAAAAAAWA", "Kasprzaka", "1/1", invalidPostalCode2);
		
		// then
		super.testConstructorArgs(isValidExpected, addressInvalid0);
		super.testConstructorArgs(isValidExpected, addressInvalid1);
		super.testConstructorArgs(isValidExpected, addressInvalid2);
	}
}
