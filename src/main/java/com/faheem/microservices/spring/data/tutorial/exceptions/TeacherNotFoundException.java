package com.faheem.microservices.spring.data.tutorial.exceptions;

public class TeacherNotFoundException extends Exception{

    public TeacherNotFoundException(String message){
        super(message);
    }
}
