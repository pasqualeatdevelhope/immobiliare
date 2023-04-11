package org.example.exception;

public class InvalidImmobileException extends RuntimeException {

	public InvalidImmobileException() {
		super();
	}

	public InvalidImmobileException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InvalidImmobileException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidImmobileException(String message) {
		super(message);
	}

	public InvalidImmobileException(Throwable cause) {
		super(cause);
	}

}
