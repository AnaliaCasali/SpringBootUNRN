package com.demo.springBootAC.repository;

import com.demo.springBootAC.domain.Curso;
import com.demo.springBootAC.domain.Estudiante;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    // Listar todos los estSudiantes
    @Query("Select e from Estudiante e")
    List<Estudiante> findAllEstudiantes();

    List<Estudiante> findAll();

    //Listar todos los estudiantes que tengan un dni mayor a 20M y que su apellido sea “Romero”
    @Query("SELECT e FROM Estudiante e WHERE e.dni>20000000 AND e.apellido LIKE 'Romero'")
    List<Estudiante> findByRomero();

    List<Estudiante> findByApellidoEqualsAndDniGreaterThan(String apellido, int dni);

    /*
        Listar todos los estudiantes de forma paginada y ordenada ascendente por DNI
        Probar las siguientes combinaciones:
                ○ pagina 1, tamaño 5
                ○ pagina 0, tamaño 2
    */
    @Query("SELECT e FROM Estudiante e")
    Page<Estudiante> findAllStudents(Pageable pageable);
    // test: estudianteRepository.findAllStudents(PageRequest.of(1,5, Sort.by("dni")))
    //test: estudianteRepository.findAll(PageRequest.of(0,2, Sort.by(Sort.Direction.ASC,"dni")))
}
