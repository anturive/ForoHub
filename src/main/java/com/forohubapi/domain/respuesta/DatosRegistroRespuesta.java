package com.forohubapi.domain.respuesta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroRespuesta(
        @NotNull
        String topico,
        @NotBlank
        String mensaje,
        @NotBlank
        String autor
) {
}