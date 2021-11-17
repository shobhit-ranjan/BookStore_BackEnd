package com.bookstore.app.exception;

import java.util.List;

import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.bookstore.app.dto.ResponseDto;


import lombok.extern.slf4j.Slf4j;


@ControllerAdvice
@Slf4j
public class RegisterExceptionHandler {
	

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ResponseDto> NotFoundException(CustomException exception) {
		ResponseDto responseDto = new ResponseDto("Exception while processing Rest request ", exception.getMessage());
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDto> handlerMethodargumentNotValidException(
			MethodArgumentNotValidException exception) {
		List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
		List<String> errorMessage = errorList.stream().map(o -> o.getDefaultMessage()).collect(Collectors.toList());
		ResponseDto responseDto = new ResponseDto("Exception while processing Rest request ", errorMessage);
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.BAD_REQUEST);
	}


}
