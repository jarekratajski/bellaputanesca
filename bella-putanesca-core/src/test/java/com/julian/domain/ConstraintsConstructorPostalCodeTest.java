package com.julian.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ConstraintsConstructorPostalCodeTest extends ConstraintsTest {

	@Test
	public void testPostalCodeAddressValid() {
		// given
		boolean isValidExpected = true;
		String validPostalCode = "01-225";
		
		// when
		Address addressValid = new Address("Wielka WARSZAAAAAAWA", "Kasprzaka", "1/1", validPostalCode);

		// then
		super.testConstructorArgs(addressValid, isValidExpected);
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
		super.testConstructorArgs(addressInvalid0, isValidExpected);
		super.testConstructorArgs(addressInvalid1, isValidExpected);
		super.testConstructorArgs(addressInvalid2, isValidExpected);
	}
}