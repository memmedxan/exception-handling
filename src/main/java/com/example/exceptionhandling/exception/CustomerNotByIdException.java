package com.example.exceptionhandling.exception;

public class CustomerNotByIdException extends RuntimeException{


    public CustomerNotByIdException(String message){
        super  (message);
    }
}
