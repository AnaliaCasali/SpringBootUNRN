package com.demo.springBootAC.repository;

import com.demo.springBootAC.domain.Curso;
import com.demo.springBootAC.domain.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    //Listar todos los cursos
    @Query("SELECT c FROM Curso c")
    List<Curso> findAllCursos();

    List<Curso> findAll();
    // Listar todos los cursos que hayan empezado después de “01/02/2020”
    @Query("SELECT c FROM Curso c WHERE c.fechaDeInicio > :fecha")
    List<Curso> findByFechaAfter2020(@Param("fecha") LocalDate fecha);
    //para test cursoRepository.findByFechaAfter2020(LocalDate.parse("2020-02-01"));
    List<Curso> findByFechaDeInicioAfter(LocalDate fecha);
    //para test: cursoRepository.findByFechaDeInicioAfter(LocalDate.parse("2020-02-01"));


}
