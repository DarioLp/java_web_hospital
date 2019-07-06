package com.guilder.hospital.exceptions;

public class UnauthorizedException extends RuntimeException {

    public UnauthorizedException(){super("No tienes permisos para realizar esta acción");}
}
