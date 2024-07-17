package com.forohubapi.infra.errors;

public class DatosExistentes extends RuntimeException{
    public DatosExistentes(String mensaje) {
        super(mensaje);
    }
}
