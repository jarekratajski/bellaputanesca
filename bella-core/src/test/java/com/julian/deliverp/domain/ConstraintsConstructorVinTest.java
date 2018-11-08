package com.julian.deliverp.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ConstraintsConstructorVinTest extends ConstraintsTests {

	@Test
	public void testVinVehicleValid() {
		// given
		boolean isValidExpected = true;
		String validVin = "3GNGK26G93G127359";

		// when
		Vehicle vehicleValid = new Vehicle(validVin);

		// then
		super.testConstructorArgs(isValidExpected, vehicleValid);
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
		super.testConstructorArgs(isValidExpected, vehicleInvalid0);
		super.testConstructorArgs(isValidExpected, vehicleInvalid1);
		super.testConstructorArgs(isValidExpected, vehicleInvalid2);
	}

}
