package com.guilder.hospital.exceptions;

public class SpecialtyNotFoundException extends RuntimeException{

    public SpecialtyNotFoundException(long id){
        super("No se encontro la especialidad "+ id);
    }
}
