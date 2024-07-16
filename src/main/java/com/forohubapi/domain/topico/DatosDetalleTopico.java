package com.forohubapi.domain.topico;

import java.time.LocalDateTime;

public record DatosDetalleTopico(
        String titulo,
        String mensaje,
        LocalDateTime fecha,
        String estado,
        String autor,
        String curso
) {
    public DatosDetalleTopico(Topico topico) {
        this(topico.getTitulo(), topico.getMensaje(), topico.getFecha(),topico.getStatus(),topico.getUsuario().getNombre(),topico.getCurso().getNombre());
    }
}
