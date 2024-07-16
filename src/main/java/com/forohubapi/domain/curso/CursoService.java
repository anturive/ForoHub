package com.forohubapi.domain.curso;

import com.forohubapi.infra.DatosExistentes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public Curso registrarCurso(DatosRegistroCurso datosRegistroCurso) throws Exception {
        var cursoBuscado = buscarCurso(datosRegistroCurso.curso());
        if (cursoBuscado != null) {
            if(cursoBuscado.getNombre().trim().toLowerCase().contains(datosRegistroCurso.curso().trim().toLowerCase())
                    && cursoBuscado.getCategoria().toString().trim().toLowerCase().contains(datosRegistroCurso.categoria().toString().trim().toLowerCase())){
                throw new DatosExistentes("El curso ya existe");
            }
        }
        return cursoRepository.save(new Curso(datosRegistroCurso));
    }

    public List<DatosListarCursos> listarCurso(){
        return cursoRepository.findAll().stream()
                .map(e->new DatosListarCursos(e.getId(),e.getNombre(),e.getCategoria().toString())).toList();
    }

    public Curso buscarCurso(String nombre){
        var cursoBuscado = cursoRepository.findByNombre(nombre);
        if(cursoBuscado.isPresent()){
            var curso = cursoBuscado.get();
            return curso;
        }
        return null;
    }
}
