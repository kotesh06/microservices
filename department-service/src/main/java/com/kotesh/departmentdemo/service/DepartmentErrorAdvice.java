package com.kotesh.departmentdemo.service;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DepartmentErrorAdvice {

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> handleRuntimeException(RuntimeException e){
		return error(HttpStatus.INTERNAL_SERVER_ERROR,e);
		
	}
	
	@ExceptionHandler(DepartmentNotFoundException.class)
	public ResponseEntity<String> handleRuntimeException(DepartmentNotFoundException e){
		return error(HttpStatus.NOT_FOUND,e);
		
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> handleRuntimeException(ResourceNotFoundException e){
		return error(HttpStatus.NOT_FOUND,e);
		
	}
	
	private ResponseEntity<String> error(HttpStatus status, Exception e) {
       // log.error("Exception : ", e);
        return ResponseEntity.status(status).body(e.getMessage());
    }
}
