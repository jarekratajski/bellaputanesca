package com.julian.bella.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class VinValidator implements ConstraintValidator<VinConstraint, String> {

	final int[] WEIGHTS = { 8, 7, 6, 5, 4, 3, 2, 10, 0, 9, 8, 7, 6, 5, 4, 3, 2};
	final int CHECK_SUM_MODULO = 11;

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		value = value.toLowerCase();
		return value.length() == 17 
				&& value.matches("^[a-z0-9]*$") 
				&& !value.matches("[i|o|q]") 
				&& isValidChecksum(value);
	}

	private boolean isValidChecksum(String value) {
		int[] values = mapToNumbers(value);
		int checkSum = Checksum.calculate(values, WEIGHTS, CHECK_SUM_MODULO);		
		return value.charAt(8) == 'x' ? checkSum == 10 : checkSum == values[8];
	}

	private static int[] mapToNumbers(String value) {
		return value.chars().map(x -> {
			if (x >= '1' && x <= '9') return x;
			if (x >= 'a' && x <= 'h') return x - 48;
			if ((x >= 'j' && x <= 'n') || (x == 'p') || (x == 'r')) return x - 57;
			if (x >= 's' && x <= 'z') return x - 65;
			return 48;
		}).map(Character::getNumericValue).toArray();
	}
}
