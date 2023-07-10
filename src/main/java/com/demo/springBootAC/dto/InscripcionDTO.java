package com.demo.springBootAC.dto;

import com.demo.springBootAC.domain.Curso;
import com.demo.springBootAC.domain.Estado;
import com.demo.springBootAC.domain.Estudiante;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
@Data
@AllArgsConstructor
public class InscripcionDTO {
    private LocalDate fechaDeInscripcion;
    private Estado estado;// (Aceptada, Rechazada, Pendiente)
    private Curso curso;
    private Estudiante  estudiante;

}
