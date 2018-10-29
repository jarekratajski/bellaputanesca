package com.julian.domain;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;

public class ConstraintsTest extends AbstractConfigConstraintsTest {
	
	public <T> void testConstructorArgs(T obj, boolean isValidExpected) {
	// when
	Set<ConstraintViolation<T>> violations = validator.validate(obj);
	// then
	assertEquals(violations.isEmpty(), isValidExpected);
	}
}