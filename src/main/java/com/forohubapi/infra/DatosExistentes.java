package com.forohubapi.infra;

public class DatosExistentes extends RuntimeException{
    public DatosExistentes(String mensaje) {
        super(mensaje);
    }
}
