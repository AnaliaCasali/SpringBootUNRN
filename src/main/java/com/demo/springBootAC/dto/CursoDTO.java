package com.demo.springBootAC.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class CursoDTO {
    private String nombre;
    private LocalDate fechaDeInicio;
    private String descripcion;
    private LocalDate fechaDeFin;

}
