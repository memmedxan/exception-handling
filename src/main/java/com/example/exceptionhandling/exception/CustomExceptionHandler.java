package com.example.exceptionhandling.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class CustomExceptionHandler {

@ExceptionHandler(CustomerNullException.class)
    public ResponseEntity<?> customerNotNull(CustomerNullException customerNullException){
        List<String> detail = new ArrayList<>();
        detail.add(customerNullException.getMessage());
        detail.add(customerNullException.getMessage());
        detail.add(customerNullException.getMessage());
        ErrorResponse errorResponse = new ErrorResponse("Custumer Not Null",detail);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(CustomerNotByIdException.class)
    public ResponseEntity<?> customerNotFoundById(CustomerNotByIdException customerNotByIdException){
        List<String> detail = new ArrayList<>();
        detail.add(customerNotByIdException.getMessage());
        detail.add(customerNotByIdException.getMessage());
        detail.add(customerNotByIdException.getMessage());
        ErrorResponse errorResponse = new ErrorResponse("Custumer Not Found by ID",detail);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

    }




}
