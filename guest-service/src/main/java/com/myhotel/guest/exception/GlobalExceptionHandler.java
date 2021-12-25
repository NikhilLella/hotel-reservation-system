package com.myhotel.guest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.myhotel.guest.model.ErrorResponse;
import com.myhotel.guest.model.GuestApiResponse;
import com.myhotel.guest.model.GuestDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {
/*	@ExceptionHandler(GuestServiceException.class)
	public ResponseEntity<ErrorResponse> handleHttpExceptions(GuestServiceException e) {
		log.error("Guest Service Exception: {}", e.getMessage());
		ErrorResponse errorResponse = null;
	
			errorResponse = new ErrorResponse(e.getHttpStatus().value(),e.getMessage(),null);
		
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
}*/
	@ExceptionHandler(GuestServiceException.class)
	public ResponseEntity<GuestApiResponse<Void>> handleHttpExceptions(GuestServiceException e) {
		log.error("Guest Service Exception: {}", e.getMessage());
		ErrorResponse errorResponse = null;
	
			errorResponse = new ErrorResponse(e.getHttpStatus().value(),e.getMessage(),null);
			GuestApiResponse<Void> response = new GuestApiResponse<Void>(null, e.getHttpStatus(), errorResponse);

		
		return new  ResponseEntity<GuestApiResponse<Void>>(response, e.getHttpStatus());
	}
}
