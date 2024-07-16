package com.forohubapi.controller;

import com.forohubapi.domain.respuesta.DatosDetalleRespuesta;
import com.forohubapi.domain.respuesta.DatosRegistroRespuesta;
import com.forohubapi.domain.respuesta.RespuestaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/respuestas")
public class RespuestaController {

    @Autowired
    private RespuestaService respuestaService;

    @PostMapping
    @Transactional
    public ResponseEntity registrarRespuesta(@RequestBody @Valid DatosRegistroRespuesta datosRegistroRespuesta,
                                             UriComponentsBuilder uriComponentsBuilder) {
        var respuesta = respuestaService.registrarRespuesta(datosRegistroRespuesta);
        URI uri = uriComponentsBuilder.path("/respuestas/{id}").buildAndExpand(respuesta.id()).toUri();
        return ResponseEntity.created(uri).body(respuesta);
    }

    @GetMapping
    public ResponseEntity<List<DatosDetalleRespuesta>> listarRespuestas() {
        return ResponseEntity.ok().body(respuestaService.listarRespuestas());
    }

}
