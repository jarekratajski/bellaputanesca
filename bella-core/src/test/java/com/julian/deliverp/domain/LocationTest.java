package com.julian.deliverp.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class LocationTest {

	@Test
	public void testAreaAddressDoubleDouble() {
		// given
		Address address = new Address("Warszawa", "Aleja Prymasa Tysiąclecia", "4a", "00-001");
		
		// having
		Location location = new Location(address, 0, 0);
		
		// then
		assertEquals(address.getId(), location.id);
	}

}
