package com.somic.pruebatecnica.web.controllers;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.somic.pruebatecnica.persistence.entities.Articulo;
import com.somic.pruebatecnica.domain.dto.ArticuloDto;
import com.somic.pruebatecnica.domain.services.Articulo.ArticuloService;
import com.somic.pruebatecnica.domain.services.Laboratorio.LaboratorioService;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/articulo")
public class ArticuloController {

    private final ArticuloService articuloService;
    private final LaboratorioService laboratorioService;

    public ArticuloController(ArticuloService articuloService, LaboratorioService laboratorioService) {
        this.articuloService = articuloService;
        this.laboratorioService = laboratorioService;
    }

    //VER TODAS LAS ARTICULOS 

    @GetMapping
    public ResponseEntity<List<ArticuloDto>> listarArticulos() {
        List<Articulo> articulos = articuloService.findAll();
        List<ArticuloDto> articuloDTO = articulos.stream().map(ArticuloDto::new).collect(Collectors.toList());
        return ResponseEntity.ok(articuloDTO);
    }

    //OBTENER UNA ARTICULO ESPECIFICA POR SU ID

    @GetMapping("/{id}")
    public ResponseEntity<ArticuloDto> obtenerArticulo(@PathVariable Long id) {
        Optional<Articulo> articulo = articuloService.findById(id);
        return articulo.map(c -> ResponseEntity.ok(new ArticuloDto(c))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //CREAR NUEVAS ARTICULOES AMIGO

    @PostMapping("/nuevo")
    public ResponseEntity<ArticuloDto> crearArticulo(@RequestBody Articulo articulo) {
        if (laboratorioService.findById(articulo.getLaboratorio().getLabCod()).isEmpty()) {
            return ResponseEntity.badRequest().build(); 
        }
        Articulo nuevaArticulo = articuloService.save(articulo);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ArticuloDto(nuevaArticulo));
    }

    //ACTUALIZAR LAS ARTICULOES EXISTENTES
    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ArticuloDto> actualizarArticulo(@PathVariable Long id, @RequestBody Articulo articulo) {
        if (articuloService.findById(id).isPresent()) {
            articulo.setArtCod(id);
            Articulo articuloActualizada = articuloService.update(id, articulo);
            return ResponseEntity.ok(new ArticuloDto(articuloActualizada));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //EXTERMINAR ARTICULOES 

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarArticulo(@PathVariable Long id) {
        if (articuloService.findById(id).isPresent()) {
            articuloService.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }    

}

