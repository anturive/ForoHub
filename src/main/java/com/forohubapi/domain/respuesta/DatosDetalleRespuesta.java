package com.forohubapi.domain.respuesta;

import java.time.LocalDateTime;

public record DatosDetalleRespuesta(
        Long id,
        String topico,
        String mensaje,
        LocalDateTime fecha,
        String autor
) {
    public DatosDetalleRespuesta(Respuesta respuesta) {
        this(respuesta.getId(), respuesta.getTopico().getTitulo(), respuesta.getMensaje(), respuesta.getFecha(),respuesta.getAutor().getNombre());
    }
}
