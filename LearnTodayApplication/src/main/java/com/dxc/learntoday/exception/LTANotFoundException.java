package com.dxc.learntoday.exception;

public class LTANotFoundException extends RuntimeException {

	public LTANotFoundException(String message) {
		super(message);
	}

	public LTANotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public LTANotFoundException(Throwable cause) {
		super(cause);
	}

}
