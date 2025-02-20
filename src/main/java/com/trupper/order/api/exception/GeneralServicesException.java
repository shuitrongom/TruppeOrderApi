package com.trupper.order.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class GeneralServicesException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public GeneralServicesException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GeneralServicesException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public GeneralServicesException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public GeneralServicesException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public GeneralServicesException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
