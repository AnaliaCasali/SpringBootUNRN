package com.demo.springBootAC.service;

import com.demo.springBootAC.domain.Curso;
import com.demo.springBootAC.dto.CursoDTO;
import com.demo.springBootAC.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;

    public CursoDTO saveCurso(CursoDTO cursoDTO) {
        Curso curso = new Curso(
                null,
                cursoDTO.getNombre(),
                cursoDTO.getFechaDeInicio(),
                cursoDTO.getDescripcion(),
                cursoDTO.getFechaDeFin()
        );
        cursoRepository.save(curso);
        return cursoDTO;
    }

    public List<CursoDTO> findAll() {
        return cursoRepository.findAll()
                .stream().map(e -> new CursoDTO(e.getNombre(),e.getFechaDeInicio(), e.getDescripcion(), e.getFechaDeFin()))
                .collect(Collectors.toList());
    }

    public CursoDTO update(Long id, CursoDTO cursoDTO) {
        Curso curso = new Curso(id, cursoDTO.getNombre(), cursoDTO.getFechaDeInicio(), cursoDTO.getDescripcion(), cursoDTO.getFechaDeFin());
        cursoRepository.save(curso);
        return cursoDTO;
    }

    public CursoDTO find(Long id) {
        Optional<Curso> cursoOptional = cursoRepository.findById(id);
        if (cursoOptional.isEmpty()) {
            throw new RuntimeException("Id Curso invalido");
        }
        Curso e = cursoOptional.get();
        return new CursoDTO(e.getNombre(), e.getFechaDeInicio(), e.getDescripcion(), e.getFechaDeFin());
    }

    public void delete(Long id) {
        cursoRepository.deleteById(id);
    }



}
