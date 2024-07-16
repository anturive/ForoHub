package com.forohubapi.infra;

public class DatosInexistentes extends RuntimeException {
    public DatosInexistentes(String message) {
        super(message);
    }
}

