package com.forohubapi.infra.errors;

public class DatosInexistentes extends RuntimeException {
    public DatosInexistentes(String message) {
        super(message);
    }
}

