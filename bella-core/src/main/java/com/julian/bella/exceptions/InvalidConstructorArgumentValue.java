package com.julian.bella.exceptions;

public class InvalidConstructorArgumentValue extends RuntimeException {

	/**
	 * auto-generated
	 */
	private static final long serialVersionUID = 3747260279799827789L;

	public InvalidConstructorArgumentValue() {
		
	}
	
	public InvalidConstructorArgumentValue(String message) {
		super(message);
	}
	
	public InvalidConstructorArgumentValue(Throwable throwable) {
		super(throwable);
	}
	
	public InvalidConstructorArgumentValue(String message, Throwable throwable) {
		super(message, throwable);
	}
}
