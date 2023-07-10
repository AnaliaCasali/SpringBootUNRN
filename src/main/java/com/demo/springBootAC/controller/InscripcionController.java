package com.demo.springBootAC.controller;

import com.demo.springBootAC.dto.EstudianteDTO;
import com.demo.springBootAC.dto.InscripcionDTO;
import com.demo.springBootAC.service.EstudianteService;
import com.demo.springBootAC.service.InscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/inscripcion")
public class InscripcionController {
    @Autowired
    InscripcionService inscripcionService;

    @PostMapping
    public InscripcionDTO save(@RequestBody InscripcionDTO inscripcionDTO) {
        return inscripcionService.saveInscripcion(inscripcionDTO);
    }
}
