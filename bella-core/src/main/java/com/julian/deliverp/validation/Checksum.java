package com.julian.deliverp.validation;

public final class Checksum {

	static int calculate(int[] values, int[] weights, int modulo) {
		int result = 0;
		for (int i = 0; i < weights.length; i++) {
			result += weights[i] * values[i];
		}
		return (result % modulo);
	}
}
