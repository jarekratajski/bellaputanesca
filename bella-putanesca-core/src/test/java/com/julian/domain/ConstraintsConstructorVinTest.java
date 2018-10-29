package com.julian.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ConstraintsConstructorVinTest extends ConstraintsTest {

	@Test
	public void testVinVehicleValid() {
		// given
		boolean isValidExpected = true;
		String validVin = "3GNGK26G93G127359";

		// when
		Vehicle vehicleValid = new Vehicle(validVin);

		// then
		super.testConstructorArgs(vehicleValid, isValidExpected);
		assertEquals(validVin, vehicleValid.getVin());
	}

	@Test
	public void testVinVehicleInvalid() {
		// given
		boolean isValidExpected = false;

		// when
		Vehicle vehicleInvalid0 = new Vehicle("1");
		Vehicle vehicleInvalid1 = new Vehicle("3GNGK26G93G12735 ");
		Vehicle vehicleInvalid2 = new Vehicle("3GNGK26G93G127358");

		// then
		super.testConstructorArgs(vehicleInvalid0, isValidExpected);
		super.testConstructorArgs(vehicleInvalid1, isValidExpected);
		super.testConstructorArgs(vehicleInvalid2, isValidExpected);
	}

}