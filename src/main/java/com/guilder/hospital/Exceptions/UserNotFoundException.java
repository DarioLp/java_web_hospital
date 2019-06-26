package com.guilder.hospital.Exceptions;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(long id){
        super("No se encontro el usuario "+ id);
    }
}
