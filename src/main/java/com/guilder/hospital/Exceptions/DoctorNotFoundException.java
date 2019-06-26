package com.guilder.hospital.Exceptions;

public class DoctorNotFoundException extends RuntimeException{

    public DoctorNotFoundException(long id){
        super("No se encontro el doctor"+ id);
    }
}
