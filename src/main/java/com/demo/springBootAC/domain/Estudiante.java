package com.demo.springBootAC.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Estudiante")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "email")
    private String email;
    @Column(name = "dni")
    private int dni;
    @Column(name = "fecha_de_nacimiento")
    private LocalDate fechaDeNacimiento;
    @Transient
    private int  edad;

    public Estudiante (String nombre, String apellido, String email, int dni, LocalDate fechaNac)
    {
        this.dni=dni;
        this.nombre=nombre;
        this.apellido=apellido;
        this.fechaDeNacimiento=fechaNac;
        this.email=email;
    }
    public boolean esMayorDeEdad(){
        Period edad = Period.between(this.fechaDeNacimiento, LocalDate.now());
        if (edad.getYears() >= 18)
             return true;
        else
            return false;
    }
    public int getEdad(){
        Period edad = Period.between(this.fechaDeNacimiento, LocalDate.now());
        return edad.getYears();
    }
}
