package com.demo.springBootAC.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Curso")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "fecha_de_inicio")
    private LocalDate fechaDeInicio;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fecha_de_fin")
    private LocalDate fechaDeFin;
    //@OneToMany
    //List<Estudiante> estudianteList;

 }
