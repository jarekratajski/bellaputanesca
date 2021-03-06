package com.julian.bella.validation;

/**
 * 
 * common checksum pattern is to multiply the numbers with corresponding weights, make sum of it and return residual 
 * from division the sum by "modulo"
 *
 */
public final class Checksum {

	static int calculate(int[] values, int[] weights, int modulo) {
		int result = 0;
		for (int i = 0; i < weights.length; i++) {
			result += weights[i] * values[i];
		}
		return (result % modulo);
	}
}
