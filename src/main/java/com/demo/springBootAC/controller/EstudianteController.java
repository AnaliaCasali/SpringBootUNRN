package com.demo.springBootAC.controller;

import com.demo.springBootAC.dto.EstudianteDTO;
import com.demo.springBootAC.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiante")
public class EstudianteController {
    @Autowired
    EstudianteService estudianteService;

    @PostMapping
    public EstudianteDTO save(@RequestBody EstudianteDTO estudianteDTO) {
        return estudianteService.saveEstudiante(estudianteDTO);
    }

    @GetMapping
    public List<EstudianteDTO> all() {
        return estudianteService.findAll();
    }

    @PutMapping("/{id}")
    public EstudianteDTO update(@PathVariable Long id, @RequestBody EstudianteDTO estudianteDTO) {
        return estudianteService.update(id, estudianteDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        estudianteService.delete(id);

    }
}
