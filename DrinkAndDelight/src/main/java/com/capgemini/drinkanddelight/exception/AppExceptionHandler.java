package com.capgemini.drinkanddelight.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler {

	@ExceptionHandler({RawMaterialOrderNotFoundException.class})
	  public ResponseEntity<String> handleError(RawMaterialOrderNotFoundException exception){
	      System.out.println("Exception handled");
	      return new ResponseEntity<>(exception.getMessage(),HttpStatus.NOT_FOUND);
	  
  }
}
