package com.salesken.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(StudentDetailsException.class)
	public ResponseEntity<CustomizeErrorDetails> studentDetailsHandler(StudentDetailsException e, WebRequest re){
		CustomizeErrorDetails err = new CustomizeErrorDetails(LocalDateTime.now(), e.getMessage(), re.getDescription(false));
		
		return new ResponseEntity<CustomizeErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(StudentMarksSemesterWiseException.class)
	public ResponseEntity<CustomizeErrorDetails> StudentMarksSemesterWiseExceptionHandler(StudentMarksSemesterWiseException e, WebRequest re){
		CustomizeErrorDetails err = new CustomizeErrorDetails(LocalDateTime.now(), e.getMessage(), re.getDescription(false));
		
		return new ResponseEntity<CustomizeErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<CustomizeErrorDetails> allExceptionHandler(Exception e, WebRequest re){
		CustomizeErrorDetails err = new CustomizeErrorDetails(LocalDateTime.now(), e.getMessage(), re.getDescription(false));
		
		return new ResponseEntity<CustomizeErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<CustomizeErrorDetails> illegealArgumentExceptionHandler(IllegalArgumentException e, WebRequest re){
		CustomizeErrorDetails err = new CustomizeErrorDetails(LocalDateTime.now(), e.getMessage(), re.getDescription(false));
		
		return new ResponseEntity<CustomizeErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<CustomizeErrorDetails> invalidArgumentExceptionHandler(MethodArgumentNotValidException e){
		CustomizeErrorDetails err = new CustomizeErrorDetails(LocalDateTime.now(), e.getMessage(), e.getBindingResult().getFieldError().getDefaultMessage());
		
		return new ResponseEntity<CustomizeErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
}
