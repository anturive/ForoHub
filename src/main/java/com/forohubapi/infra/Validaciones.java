package com.forohubapi.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Validaciones {

    @ExceptionHandler(DatosExistentes.class)
    public ResponseEntity errorHandlerDatosExistentes(Exception ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity errorHandlerEntityNotFound(Exception ex){
        return ResponseEntity.badRequest().body("No se pudo encontrar");
    }

    @ExceptionHandler(DatosInexistentes.class)
    public ResponseEntity errorHandlerDatosInexistentes(Exception ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
