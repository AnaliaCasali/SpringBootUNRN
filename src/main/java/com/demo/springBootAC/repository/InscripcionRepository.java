package com.demo.springBootAC.repository;

import com.demo.springBootAC.domain.Estado;
import com.demo.springBootAC.domain.Estudiante;
import com.demo.springBootAC.domain.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {

    //    Listar todas las inscripciones rechazadas o pendiente
    @Query("SELECT i FROM Inscripcion i WHERE i.estado LIKE 'RECHAZADA' OR i.estado LIKE 'PENDIENTE'")
    List<Inscripcion> findAllIncripcionesRechazadasOPendientes();

    List<Inscripcion> findByEstadoContainingOrEstadoContaining(Estado estado1, Estado estado2);
    //Test: inscripcionRepository.findByEstadoContainingOrEstadoContaining(Estado.Pendiente, Estado.Rechazada)

    List<Inscripcion> findByEstadoIsNot(Estado estado1);
    //Test:inscripcionRepository.findByEstadoIsNot(Estado.Aceptada)

    //Listar todas las inscripciones en base a un parámetro de estado
    @Query("SELECT i FROM Inscripcion i WHERE i.estado LIKE :unEstado")
    List<Inscripcion> findByOneStatus(@Param("unEstado") Estado unEstado);
    //Test: inscripcionRepository.findByOneStatus(Estado.Aceptada)

    List<Inscripcion> findByEstadoEquals(Estado estado);
    //Test: inscripcionRepository.findByEstadoEquals(Estado.Aceptada)

    List<Inscripcion> findByFechaDeInscripcion(LocalDate fechaIncripcion);
    //Test inscripcionRepository.findByFechaDeInscripcion(LocalDate.parse("2023-01-01"))

    // Listar todas las inscripciones en base a un parámetro de estado utilizando consulta nativa
    @Query(value = "SELECT * FROM Inscripcion i WHERE i.estado LIKE :unEstado", nativeQuery = true)
    List<Inscripcion> findByOneStatusNative(@Param("unEstado") Estado unEstado);
    //Test : inscripcionRepository.findByOneStatus(Estado.Aceptada)
}

