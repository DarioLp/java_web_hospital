package com.guilder.hospital.exceptions;

public class RegisteredUserException extends RuntimeException{

    public RegisteredUserException(){
        super("El dni ingresado ya se encuentra registrado.");
    }
}
