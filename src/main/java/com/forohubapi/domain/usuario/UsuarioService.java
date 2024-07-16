package com.forohubapi.domain.usuario;

import com.forohubapi.infra.DatosExistentes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public DatosDetalleUsuario registrarUsuario(DatosRegistroUsuario datosRegistroUsuario){
        var usuarioBuscado = buscarCorreo(datosRegistroUsuario.correo());
        if(usuarioBuscado != null){
            throw new DatosExistentes("El correo ingresado ya existe");
        }
        var usuario = usuarioRepository.save(new Usuario(datosRegistroUsuario));
        return new DatosDetalleUsuario(usuario);
    }

    public Usuario buscarUsuario(String autor){
        var usuarioBuscado = usuarioRepository.findByNombre(autor);
        if(usuarioBuscado.isPresent()){
            Usuario usuario = usuarioBuscado.get();
            return usuario;
        }
        return null;
    }

    public Usuario buscarCorreo(String correo){
        var usuarioBuscado = usuarioRepository.findByCorreo(correo);
        if(usuarioBuscado.isPresent()){
            Usuario usuario = usuarioBuscado.get();
            return usuario;
        }
        return null;
    }

}
