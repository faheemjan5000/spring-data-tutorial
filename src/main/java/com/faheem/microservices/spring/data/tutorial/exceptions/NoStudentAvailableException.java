package com.faheem.microservices.spring.data.tutorial.exceptions;

public class NoStudentAvailableException extends Exception{

    public NoStudentAvailableException(String message){
        super(message);
    }
}
