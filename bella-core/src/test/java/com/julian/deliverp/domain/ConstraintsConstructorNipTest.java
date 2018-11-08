package com.julian.deliverp.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ConstraintsConstructorNipTest extends ConstraintsTests {

	@Test
	public void testNipClientValid() {
		// given
		boolean isValidExpected = true;
		String validNip = "5683293405";
		
		// when
		Client clientValid = new Client(validNip);

		// then
		super.testConstructorArgs(isValidExpected, clientValid);
		assertEquals(validNip, clientValid.getNip());
	}
	
	@Test
	public void testNipClientInvalid() {
		// given
		boolean isValidExpected = false;
		
		// when
		Client clientInvalid0 = new Client("1");
		Client clientInvalid1 = new Client("568329340 ");
		Client clientInvalid2 = new Client("5683293404");
		Client clientInvalid3 = new Client("5a83293405");
		
		// then
		super.testConstructorArgs(isValidExpected, clientInvalid0);
		super.testConstructorArgs(isValidExpected, clientInvalid1);
		super.testConstructorArgs(isValidExpected, clientInvalid2);
		super.testConstructorArgs(isValidExpected, clientInvalid3);
	}
}
