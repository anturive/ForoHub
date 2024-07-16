package com.forohubapi.domain.curso;

public record DatosDetalleCurso(
        String nombre,
        String categoria
) {
    public DatosDetalleCurso(DatosRegistroCurso datosRegistroCurso) {
        this(datosRegistroCurso.curso(),datosRegistroCurso.categoria().toString());
    }
}