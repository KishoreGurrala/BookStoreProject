package com.book.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.book.exceptions.payload.ApiResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
	/*
	 * @ExceptionHandler(Exception.class) public ResponseEntity<String>
	 * handleException(Exception e) { // Handle the exception here // You can
	 * customize the response based on the exception return
	 * ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
	 * body("Internal Server Error"); }
	 */
    
    @ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<ApiResponse> handleCustomException(BookNotFoundException e) {
		// Handle the custom exception here
		// You can customize the response based on the exception
		String msg = e.getMessage();
		ApiResponse resp = ApiResponse.builder().message(msg).success(true).status(HttpStatus.NOT_FOUND).build();
		return new ResponseEntity<ApiResponse>(resp, HttpStatus.NOT_FOUND);
	}
    
    @ExceptionHandler(BookOutofStockException.class)
	public ResponseEntity<ApiResponse> handleCustomException(BookOutofStockException e) {
		// Handle the custom exception here
		// You can customize the response based on the exception
		String msg = e.getMessage();
		ApiResponse resp = ApiResponse.builder().message(msg).success(true).status(HttpStatus.NOT_FOUND).build();
		return new ResponseEntity<ApiResponse>(resp, HttpStatus.NOT_FOUND);
	}

}
