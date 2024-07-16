package com.forohubapi.domain.curso;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroCurso(
        @NotBlank
        String curso,
        @NotNull
        Categoria categoria
) {
}