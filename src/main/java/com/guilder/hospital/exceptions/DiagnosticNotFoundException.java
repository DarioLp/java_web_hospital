package com.guilder.hospital.exceptions;

public class DiagnosticNotFoundException extends RuntimeException{

    public DiagnosticNotFoundException(long id){
        super("No se encontro el diagnostico "+ id);
    }
}
