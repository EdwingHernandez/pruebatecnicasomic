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

import com.somic.pruebatecnica.domain.dto.NitDto;
import com.somic.pruebatecnica.domain.services.Nit.NitService;
import com.somic.pruebatecnica.persistence.entities.Nit;


@RestController
@RequestMapping("/nit")
public class NitController {

    private final NitService nitService;
    

    public NitController(NitService nitService) {
        this.nitService = nitService;
        
    }

    //VER TODAS LAS NITS 

    @GetMapping
    public ResponseEntity<List<NitDto>> listarNits() {
        List<Nit> nits = nitService.findAll();
        List<NitDto> nitDTO = nits.stream().map(NitDto::new).collect(Collectors.toList());
        return ResponseEntity.ok(nitDTO);
    }

    //OBTENER UNA NIT ESPECIFICA POR SU ID

    @GetMapping("/{id}")
    public ResponseEntity<NitDto> obtenerNit(@PathVariable String id) {
        Optional<Nit> nit = nitService.findById(id);
        return nit.map(c -> ResponseEntity.ok(new NitDto(c))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //CREAR NUEVAS NITES AMIGO

    @PostMapping("/nuevo")
    public ResponseEntity<NitDto> crearNit(@RequestBody Nit nit) {
        Nit nuevaNit = nitService.save(nit);
        return ResponseEntity.status(201).body(new NitDto(nuevaNit));
    }

    //ACTUALIZAR LAS NITES EXISTENTES
    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<NitDto> actualizarNit(@PathVariable String id, @RequestBody Nit nit) {
        if (nitService.findById(id).isPresent()) {
            nit.setNitDocumento(id);
            Nit nitActualizada = nitService.update(id, nit);
            return ResponseEntity.ok(new NitDto(nitActualizada));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //EXTERMINAR NITES 

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarNit(@PathVariable String id) {
        if (nitService.findById(id).isPresent()) {
            nitService.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }    
    
}
