package com.trupper.order.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ValidateServicesException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ValidateServicesException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ValidateServicesException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ValidateServicesException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ValidateServicesException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ValidateServicesException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
