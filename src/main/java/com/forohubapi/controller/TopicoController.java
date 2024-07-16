package com.forohubapi.controller;

import com.forohubapi.domain.topico.DatosDetalleTopico;
import com.forohubapi.domain.topico.DatosRegistroTopico;
import com.forohubapi.domain.topico.TopicoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @PostMapping
    @Transactional
    public ResponseEntity registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico,
                                          UriComponentsBuilder uriComponentsBuilder){
        var topico = topicoService.registrarTopico(datosRegistroTopico);
        var topicoDetalle = new DatosDetalleTopico(topico);
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(topicoDetalle);
    }

    @GetMapping
    public ResponseEntity<List<DatosDetalleTopico>> listarTopicos(){
        var topicos = topicoService.listarTopicos();
        return ResponseEntity.ok().body(topicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosDetalleTopico> obtenerTopico(@PathVariable Long id){
        var topico = topicoService.bucarTopico(id);
        return ResponseEntity.ok().body(topico);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DatosDetalleTopico> actualizarTopico(@PathVariable Long id, @RequestBody @Valid DatosRegistroTopico datosRegistroTopico){
        var topico = topicoService.actualizarTopico(id,datosRegistroTopico);
        var topicoDetalle = new DatosDetalleTopico(topico);
        return ResponseEntity.ok().body(topicoDetalle);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id){
        topicoService.eliminarTopico(id);
        return ResponseEntity.noContent().build();
    }

}
