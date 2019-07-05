package com.guilder.hospital.exceptions;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(long id){
        super("No se encontro el usuario "+ id);
    }

    public UserNotFoundException(String id){
        super("No se encontro el usuario "+ id);
    }
}
