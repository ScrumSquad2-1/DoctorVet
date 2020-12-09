package com.jump.controller.advice;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jump.exception.DoctorNotFound;

@RestControllerAdvice
public class DoctorControllerAdvice {


	@ExceptionHandler(DoctorNotFound.class)
	public ResponseEntity<ExceptionResponse> handleDoctorNotFound(DoctorNotFound e)
	{
		ExceptionResponse response = new ExceptionResponse("Doctor Not Found!", "DOCTOR-404", new Date());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}
	
}
