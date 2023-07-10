package com.demo.springBootAC;

import com.demo.springBootAC.domain.Curso;
import com.demo.springBootAC.domain.Estudiante;
import com.demo.springBootAC.repository.CursoRepository;
import com.demo.springBootAC.repository.EstudianteRepository;
import com.demo.springBootAC.service.InscripcionService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
@SpringBootApplication
public class SpringBootAcApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAcApplication.class, args);

    }

    @Autowired
    EstudianteRepository estudianteRepository;
    @Autowired
    CursoRepository cursoRepository;
    @Autowired
    InscripcionService inscripcionService;

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            System.out.println("Aplicación a iniciado ");
            saveEstudiantes();
            saveCursos();
            inscripcionService.registrarInscripcion(2L, 1L);
            cursoRepository.findAll();

        };
    }

    public void saveEstudiantes() {
        estudianteRepository.saveAll(Arrays.asList(
                new Estudiante("Juan", "Romero", "juanmail@mail.com", 11231332, LocalDate.of(2001, Month.APRIL, 1)),
                new Estudiante("Jose", "Perez", "Josemail@mail.com", 31231333, LocalDate.of(1998, Month.APRIL, 1))
        ));

    }

    public void saveCursos() {
        cursoRepository.saveAll(Arrays.asList(
                new Curso(null, "Java", LocalDate.parse("2020-01-01"), "Java Avanzado", LocalDate.parse("2023-07-03")),//,listaEst
                new Curso(null, "Java 2", LocalDate.parse("2023-01-01"), "Java Avanzado 2", LocalDate.parse("2023-07-03"))//,listaEst2
        ));
    }
}