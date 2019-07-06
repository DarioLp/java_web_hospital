package com.guilder.hospital.exceptions;

public class InvalidTurnDateException extends RuntimeException {

    public InvalidTurnDateException(){
        super("Fecha invalida");
    }
}
