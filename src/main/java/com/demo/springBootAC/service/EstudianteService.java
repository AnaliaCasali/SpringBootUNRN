package com.demo.springBootAC.service;

import com.demo.springBootAC.domain.Estudiante;
import com.demo.springBootAC.dto.EstudianteDTO;
import com.demo.springBootAC.repository.EstudianteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EstudianteService {
    @Autowired
    private EstudianteRepository estudianteRepository;

    public EstudianteDTO saveEstudiante(EstudianteDTO estudianteDTO) {
        Estudiante estudiante = new Estudiante(
                null,
                estudianteDTO.getNombre(),
                estudianteDTO.getApellido(),
                estudianteDTO.getMail(),
                estudianteDTO.getDni(),
                estudianteDTO.getFechaDeNacimiento(),
                estudianteDTO.getEdad()
        );
        estudianteRepository.save(estudiante);
        return estudianteDTO;
    }

    public List<EstudianteDTO> findAll() {
        return estudianteRepository.findAll()
                .stream().map(e -> new EstudianteDTO(e.getNombre(), e.getApellido(), e.getEmail(), e.getDni(), e.getFechaDeNacimiento(), e.getEdad()))
                .collect(Collectors.toList());
    }

    public EstudianteDTO update(Long id, EstudianteDTO estudianteDTO) {
        Estudiante estudiante = new Estudiante(id, estudianteDTO.getNombre(), estudianteDTO.getApellido(), estudianteDTO.getMail(), estudianteDTO.getDni(), estudianteDTO.getFechaDeNacimiento(), estudianteDTO.getEdad());
        estudianteRepository.save(estudiante);
        return estudianteDTO;
    }

    public EstudianteDTO find(Long id) {
        Optional<Estudiante> estudianteOptional = estudianteRepository.findById(id);
        if (estudianteOptional.isEmpty()) {
            throw new RuntimeException("Id Estudiante invalido");
        }
        Estudiante e = estudianteOptional.get();
        return new EstudianteDTO(e.getNombre(), e.getApellido(), e.getEmail(), e.getDni(), e.getFechaDeNacimiento(), e.getEdad());
    }

    public void delete(Long id) {
        estudianteRepository.deleteById(id);
    }

    @Autowired
    public EstudianteService(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    public Page<Estudiante> getStudentsByPage(int pageNumber, int pageSize, String orderBy) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.ASC, orderBy));
        return estudianteRepository.findAllStudents(pageable);
    }


}
