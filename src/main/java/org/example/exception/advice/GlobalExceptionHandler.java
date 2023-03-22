package org.example.exception.advice;

import org.example.controllers.dto.StatusResponse;
import org.example.controllers.dto.StatusResponse.Status;
import org.example.exception.InvalidActivationCodeException;
import org.example.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public StatusResponse handleUserNotFoundException(UserNotFoundException e) {
		StatusResponse response = new StatusResponse();
		response.setStatus(Status.KO);
		response.setErrorMessage("USER_NOT_FOUND");
		return response;
	}
	
	@ExceptionHandler(InvalidActivationCodeException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public StatusResponse handleInvalidActivationCodeException(InvalidActivationCodeException e) {
		StatusResponse response = new StatusResponse();
		response.setStatus(Status.KO);
		response.setErrorMessage("INVALID_ACTIVATION_CODE");
		return response;
	}

}
