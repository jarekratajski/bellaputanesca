package com.julian.deliverp.domain;

import static org.junit.Assert.*;

import org.hibernate.validator.internal.constraintvalidators.hv.pl.PESELValidator;
import org.junit.Before;
import org.junit.Test;

public class EncryptingTest {

	PESELValidator peselValidator;

	@Before
	public void onStart2() {
		this.peselValidator = new PESELValidator();
		peselValidator.initialize(null);
	}

	@Test
	public void testEncryptingPesel() {
		// given
		CharSequence validPesel = "94092367705";

		// when
		Employee emp = new Shipper(validPesel.toString());

		// then
		assertTrue(peselValidator.isValid(validPesel, null));
		assertTrue(!peselValidator.isValid(emp.peselEncrypted, null));
	}
}
