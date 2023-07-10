package com.demo.springBootAC.service;

import com.demo.springBootAC.domain.Curso;
import com.demo.springBootAC.domain.Estado;
import com.demo.springBootAC.domain.Estudiante;
import com.demo.springBootAC.domain.Inscripcion;
import com.demo.springBootAC.dto.EstudianteDTO;
import com.demo.springBootAC.dto.InscripcionDTO;
import com.demo.springBootAC.repository.CursoRepository;
import com.demo.springBootAC.repository.EstudianteRepository;
import com.demo.springBootAC.repository.InscripcionRepository;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Validated
public class InscripcionService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private InscripcionRepository inscripcionRepository;


    @Transactional
    public void registrarInscripcion(@NotNull  @Positive(message = "El id no puede ser negativo") Long idEstudiante, @NotNull @Positive(message = "El id no puede ser negativo") Long idCurso)
    {


        Estudiante estudiante= estudianteRepository
                .findById(idEstudiante)
                .orElseThrow(()-> new RuntimeException("El id del estudiante no es válido"));
                // si el valor es vñalido hace la operacion get , caso contrario larga la excepción

        if(!estudiante.esMayorDeEdad())
            throw new RuntimeException("El estudiante no es mayor de edad");

        Curso curso= cursoRepository
                .findById(idCurso)
                .orElseThrow(()-> new RuntimeException("El id del curso no es válido"));



        Inscripcion inscripcion=new Inscripcion
                (null, LocalDate.now(),
            Estado.Pendiente, curso, estudiante);
        inscripcionRepository.saveAndFlush(inscripcion);

        throw new RuntimeException("Error en la aplicación al registrar Inscripcion ");
    }



    public InscripcionDTO saveInscripcion(InscripcionDTO inscripcionDTO) {
        Inscripcion inscripcion = new Inscripcion(
                null,
                inscripcionDTO.getFechaDeInscripcion(),
                inscripcionDTO.getEstado(),
                inscripcionDTO.getCurso(),
                inscripcionDTO.getEstudiante()
        );
        inscripcionRepository.save(inscripcion);
        return inscripcionDTO;
    }


}
