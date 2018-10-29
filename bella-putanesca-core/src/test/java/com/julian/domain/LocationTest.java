package com.julian.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LocationTest {

	@Test
	public void testAreaAddressDoubleDouble() {
		// given
		Address address = new Address("Warszawa", "Aleja Prymasa Tysi¹clecia", "4a", "00-001");
		
		// having
		Location area = new Location(address, 0, 0);
		
		// then
		assertEquals(address.getId(), area.id);
	}

}