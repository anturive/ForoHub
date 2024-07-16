package com.forohubapi.domain.usuario;

public record DatosDetalleUsuario(
        Long id,
        String nombre,
        String correo
) {
    public DatosDetalleUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getNombre(), usuario.getCorreo());
    }
}
