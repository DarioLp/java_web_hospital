package com.guilder.hospital.exceptions;

public class InvalidCredentialsException  extends RuntimeException {

    public InvalidCredentialsException(){
        super("Credenciales invalidas");
    }
}
