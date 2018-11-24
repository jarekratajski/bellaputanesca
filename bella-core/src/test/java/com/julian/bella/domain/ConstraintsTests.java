package com.julian.bella.domain;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;

public class ConstraintsTests extends AbstractConfigConstraintsTest {
		
	public <T> void testConstructorArgs(boolean isValidExpected, T obj) {
		// when
		Set<ConstraintViolation<T>> violations = validator.validate(obj);
		// then
		assertEquals(isValidExpected, violations.isEmpty());
	}
}
