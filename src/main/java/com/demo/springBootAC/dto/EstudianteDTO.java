package com.demo.springBootAC.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class EstudianteDTO {

    private String nombre;
    private String apellido;
    private String mail;
    private int dni;
    private LocalDate fechaDeNacimiento;
    private int edad;



}
