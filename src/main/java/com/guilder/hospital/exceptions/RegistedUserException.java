package com.guilder.hospital.exceptions;

public class RegistedUserException extends RuntimeException{

    public RegistedUserException(){
        super("El dni ingresado ya se encuentra registrado.");
    }
}
