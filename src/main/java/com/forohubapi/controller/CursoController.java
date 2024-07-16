package com.forohubapi.controller;

import com.forohubapi.domain.curso.CursoService;
import com.forohubapi.domain.curso.DatosDetalleCurso;
import com.forohubapi.domain.curso.DatosListarCursos;
import com.forohubapi.domain.curso.DatosRegistroCurso;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping
    @Transactional
    public ResponseEntity<DatosDetalleCurso> registrarCurso(@RequestBody @Valid DatosRegistroCurso datosRegistroCurso,
                                                            UriComponentsBuilder uriComponentsBuilder) throws Exception {
        var curso = cursoService.registrarCurso(datosRegistroCurso);
        var cursoDetalles = new DatosDetalleCurso(curso.getNombre(), curso.getCategoria().toString());
        URI url = uriComponentsBuilder.path("/cursos/{id}").buildAndExpand(curso.getId()).toUri();
        return ResponseEntity.created(url).body(cursoDetalles);
    }

    @GetMapping
    public ResponseEntity<List<DatosListarCursos>> listarCursos(){
        return ResponseEntity.ok().body(cursoService.listarCurso());
    }

}
