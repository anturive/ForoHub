package com.forohubapi.domain.respuesta;

import com.forohubapi.domain.topico.TopicoService;
import com.forohubapi.domain.usuario.UsuarioService;
import com.forohubapi.infra.errors.DatosInexistentes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RespuestaService {

    @Autowired
    private RespuestaRepository respuestaRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TopicoService topicoService;

    public DatosDetalleRespuesta registrarRespuesta(DatosRegistroRespuesta datosRegistroRespuesta){
        var usuario = usuarioService.buscarUsuario(datosRegistroRespuesta.autor());
        var topico = topicoService.buscarTopicoPorTitulo(datosRegistroRespuesta.topico());
        if(usuario == null){
            throw new DatosInexistentes("Autor no encontrado");
        }
        if(topico == null){
            throw new DatosInexistentes("Topico no encontrado");
        }
        var respuesta= respuestaRepository.save(new Respuesta(datosRegistroRespuesta, usuario, topico));
        return new DatosDetalleRespuesta(respuesta);
    }

    public List<DatosDetalleRespuesta> listarRespuestas(){
        return respuestaRepository.findAll().stream().map(DatosDetalleRespuesta::new).toList();
    }


}
