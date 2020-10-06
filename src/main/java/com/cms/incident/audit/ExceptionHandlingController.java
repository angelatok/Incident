package com.cms.incident.audit;


import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ExceptionHandlingController {
	@ExceptionHandler(ResourceNotFoundException.class)
	  @ResponseStatus(value = HttpStatus.NOT_FOUND)
	  public ExceptionMessage resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
		ExceptionMessage message = new ExceptionMessage(
	        HttpStatus.NOT_FOUND.value(),       
	        ex.getMessage(),
	        request.getDescription(false),
	        new Date());
	    
	    return message;
	  }
	
	  
	  @ExceptionHandler(Exception.class)
	  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	  public ExceptionMessage globalExceptionHandler(Exception ex, WebRequest request) {
		  ExceptionMessage message = new ExceptionMessage(
	        HttpStatus.INTERNAL_SERVER_ERROR.value(),  
	        ex.getMessage(),
	        request.getDescription(false),
	        new Date());
	    
	    return message;
	  }
	
	// @valid on restcontroller will throw exception if check fail.

	 @ExceptionHandler(MethodArgumentNotValidException.class)
	 @ResponseStatus(value = HttpStatus.BAD_REQUEST)
	 public ExceptionMessage invalidInput(MethodArgumentNotValidException ex, WebRequest request) {
	        ExceptionMessage response = new ExceptionMessage();
	        response.setErrorCode(HttpStatus.BAD_REQUEST.value());
	        response.setErrorMessage("Validation Error");
	        response.setDescription(request.getDescription(false));
	        response.setTimestamp(new Date());
	        return response;
	        
	 }
	
	 @ExceptionHandler(IllegalArgumentException.class)
	 @ResponseStatus(value = HttpStatus.BAD_REQUEST)
	 public ExceptionMessage invalidInput(IllegalArgumentException ex, WebRequest request) {
		 ExceptionMessage response = new ExceptionMessage();
	        response.setErrorCode(HttpStatus.BAD_REQUEST.value());
	        response.setErrorMessage("Validation Error");
	        response.setDescription(request.getDescription(false));
	        response.setTimestamp(new Date());
	        return response;
	 }

}
