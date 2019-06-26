package com.guilder.hospital.Exceptions;

public class TurnNotFoundException extends RuntimeException{

    public TurnNotFoundException(long id){
        super("No se encontro el turno "+ id);
    }
}
