package com.guilder.hospital.exceptions;

public class TurnNotFoundException extends RuntimeException{

    public TurnNotFoundException(long id){
        super("No se encontro el turno "+ id);
    }
}
