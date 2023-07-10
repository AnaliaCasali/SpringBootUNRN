package com.demo.springBootAC.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Inscripcion")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Inscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "fecha_de_inscripcion")
    private LocalDate fechaDeInscripcion;
    @Column(name = "estado")
    @Enumerated(EnumType.STRING)
    private Estado estado;// (Aceptada, Rechazada, Pendiente)
    @OneToOne
    @JoinColumn(name="curso_id")
    Curso curso;

    @ManyToOne
    @JoinColumn(name="estudiante_id")
    Estudiante estudiante;

    }
