package com.guilder.hospital.exceptions;

public class UserBloquedException extends RuntimeException{

    public UserBloquedException(){
        super("Usuario bloqueado ");
    }
}
