package com.somic.pruebatecnica.web.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.somic.pruebatecnica.domain.dto.LaboratorioDto;
import com.somic.pruebatecnica.domain.services.Laboratorio.LaboratorioService;
import com.somic.pruebatecnica.persistence.entities.Laboratorio;


@RestController
@RequestMapping("/laboratorio")
public class LaboratorioController {

    private final LaboratorioService laboratorioService;
    

    public LaboratorioController(LaboratorioService laboratorioService) {
        this.laboratorioService = laboratorioService;
        
    }

    //VER TODAS LAS LABORATORIOS 

    @GetMapping
    public ResponseEntity<List<LaboratorioDto>> listarLaboratorios() {
        List<Laboratorio> laboratorios = laboratorioService.findAll();
        List<LaboratorioDto> laboratorioDTO = laboratorios.stream().map(LaboratorioDto::new).collect(Collectors.toList());
        return ResponseEntity.ok(laboratorioDTO);
    }

    //OBTENER UNA LABORATORIO ESPECIFICA POR SU ID

    @GetMapping("/{id}")
    public ResponseEntity<LaboratorioDto> obtenerLaboratorio(@PathVariable Long id) {
        Optional<Laboratorio> laboratorio = laboratorioService.findById(id);
        return laboratorio.map(c -> ResponseEntity.ok(new LaboratorioDto(c))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //CREAR NUEVAS LABORATORIOES AMIGO

    @PostMapping("/nuevo")
    public ResponseEntity<LaboratorioDto> crearLaboratorio(@RequestBody Laboratorio laboratorio) {
        Laboratorio nuevaLaboratorio = laboratorioService.save(laboratorio);
        return ResponseEntity.status(201).body(new LaboratorioDto(nuevaLaboratorio));
    }

    //ACTUALIZAR LAS LABORATORIOES EXISTENTES
    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<LaboratorioDto> actualizarLaboratorio(@PathVariable Long id, @RequestBody Laboratorio laboratorio) {
        if (laboratorioService.findById(id).isPresent()) {
            laboratorio.setLabCod(id);
            Laboratorio laboratorioActualizada = laboratorioService.update(id, laboratorio);
            return ResponseEntity.ok(new LaboratorioDto(laboratorioActualizada));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //EXTERMINAR LABORATORIOES 

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarLaboratorio(@PathVariable Long id) {
        if (laboratorioService.findById(id).isPresent()) {
            laboratorioService.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }        

}
