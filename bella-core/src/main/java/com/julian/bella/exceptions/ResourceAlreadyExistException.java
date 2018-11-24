package com.julian.bella.exceptions;

public class ResourceAlreadyExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ResourceAlreadyExistException() {

	}

	public ResourceAlreadyExistException(String message) {
		super(message);
	}

	public ResourceAlreadyExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public ResourceAlreadyExistException(Throwable cause) {
		super(cause);
	}

	public ResourceAlreadyExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}