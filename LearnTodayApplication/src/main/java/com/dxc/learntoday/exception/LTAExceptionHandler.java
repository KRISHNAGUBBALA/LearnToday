package com.dxc.learntoday.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LTAExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<LTAErrorResponce> handleException(LTANotFoundException ine) {
		LTAErrorResponce errorResponse = new LTAErrorResponce();
		errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		errorResponse.setMessage(ine.getMessage());
		return new ResponseEntity<LTAErrorResponce>(errorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<LTAErrorResponce> handleException_1(Exception ex) {
		LTAErrorResponce errorResponse = new LTAErrorResponce();
		errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		errorResponse.setMessage(ex.getMessage());
		return new ResponseEntity<LTAErrorResponce>(errorResponse, HttpStatus.BAD_REQUEST);
	}


}
