package com.myhotel.guest.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class GuestServiceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpStatus httpStatus;

	public GuestServiceException(String message, HttpStatus httpStatus) {
		super(message);
		this.httpStatus = httpStatus;

	}

}
