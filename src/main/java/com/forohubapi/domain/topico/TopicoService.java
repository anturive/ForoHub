package com.forohubapi.domain.topico;

import com.forohubapi.domain.curso.CursoService;
import com.forohubapi.domain.usuario.UsuarioService;
import com.forohubapi.infra.DatosExistentes;
import com.forohubapi.infra.DatosInexistentes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoService cursoService;

    @Autowired
    private UsuarioService usuarioService;

    public Topico registrarTopico(DatosRegistroTopico datosRegistroTopico) {
        var curso = cursoService.buscarCurso(datosRegistroTopico.curso());
        var usuario = usuarioService.buscarUsuario(datosRegistroTopico.autor());
        var topicoBuscado = topicoRepository.findByTitulo(datosRegistroTopico.titulo());
        if(topicoBuscado.isPresent()){
            var topico = topicoBuscado.get();
            if(topico.getTitulo().trim().equalsIgnoreCase(datosRegistroTopico.titulo().trim())
                && topico.getMensaje().trim().equalsIgnoreCase(datosRegistroTopico.mensaje().trim())){
                throw new DatosExistentes("El topico ya existe!");
            }
        }
        if(curso != null && usuario != null){
            return topicoRepository.save(new Topico(datosRegistroTopico,curso,usuario));
        }
        return null;
    }

    public Topico buscarTopicoPorTitulo(String topicoTitulo){
        Optional<Topico> topico = topicoRepository.findByTitulo(topicoTitulo);
        if (topico.isPresent()) {
            return topico.get();
        }else{
            throw new DatosInexistentes("El topico no existe!");
        }
    }

    public List<DatosDetalleTopico> listarTopicos() {
        return topicoRepository.findAll().stream().map(DatosDetalleTopico::new).toList();
    }

    public DatosDetalleTopico bucarTopico(Long id) {
        var topico = topicoRepository.getReferenceById(id);
        if(topico == null){
            throw new RuntimeException("El id del topico no existe");
        }
        return new DatosDetalleTopico(topico);
    }

    public Topico actualizarTopico(Long id, DatosRegistroTopico datosRegistroTopico) {
        var topicoBuscado = topicoRepository.getReferenceById(id);
        var curso = cursoService.buscarCurso(datosRegistroTopico.curso());
        var usuario = usuarioService.buscarUsuario(datosRegistroTopico.autor());
        if(topicoBuscado == null || curso == null || usuario == null){
            throw new RuntimeException("Los datos del topico no existe");
        }else{
            var topico = topicoBuscado.actualizarTopico(datosRegistroTopico,curso,usuario);
            topicoRepository.save(topico);
            return topico;
        }
    }

    public void eliminarTopico(Long id) {
        topicoRepository.deleteById(id);
    }
}
