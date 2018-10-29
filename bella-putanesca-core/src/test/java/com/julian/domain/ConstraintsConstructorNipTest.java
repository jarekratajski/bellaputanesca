package com.julian.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ConstraintsConstructorNipTest extends ConstraintsTest {

	@Test
	public void testNipClientValid() {
		// given
		boolean isValidExpected = true;
		String validNip = "5683293405";
		
		// when
		Client clientValid = new Client(validNip);

		// then
		super.testConstructorArgs(clientValid, isValidExpected);
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
		super.testConstructorArgs(clientInvalid0, isValidExpected);
		super.testConstructorArgs(clientInvalid1, isValidExpected);
		super.testConstructorArgs(clientInvalid2, isValidExpected);
		super.testConstructorArgs(clientInvalid3, isValidExpected);
	}
}