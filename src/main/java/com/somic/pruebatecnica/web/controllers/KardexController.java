package com.somic.pruebatecnica.web.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.somic.pruebatecnica.domain.dto.KardexDto;
import com.somic.pruebatecnica.domain.services.Kardex.KardexService;
import com.somic.pruebatecnica.domain.services.Articulo.ArticuloService;
import com.somic.pruebatecnica.persistence.entities.Kardex;


@RestController
@RequestMapping("/kardex")
public class KardexController {

    private final KardexService kardexService;
    private final ArticuloService articuloService;

    public KardexController(KardexService kardexService, ArticuloService articuloService) {
        this.kardexService = kardexService;
        this.articuloService = articuloService;
    }

    //VER TODAS LAS KARDEXS 

    @GetMapping
    public ResponseEntity<List<KardexDto>> listarKardexs() {
        List<Kardex> kardexs = kardexService.findAll();
        List<KardexDto> kardexDTO = kardexs.stream().map(KardexDto::new).collect(Collectors.toList());
        return ResponseEntity.ok(kardexDTO);
    }

    //OBTENER UNA KARDEX ESPECIFICA POR SU ID

    @GetMapping("/{id}")
    public ResponseEntity<KardexDto> obtenerKardex(@PathVariable Long id) {
        Optional<Kardex> kardex = kardexService.findById(id);
        return kardex.map(c -> ResponseEntity.ok(new KardexDto(c))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //CREAR NUEVAS KARDEXES AMIGO

    @PostMapping("/nuevo")
    public ResponseEntity<KardexDto> crearKardex(@RequestBody Kardex kardex) {
        if (articuloService.findById(kardex.getArticulo().getArtCod()).isEmpty()) {
            return ResponseEntity.badRequest().build(); 
        }
        Kardex nuevaKardex = kardexService.save(kardex);
        return ResponseEntity.status(HttpStatus.CREATED).body(new KardexDto(nuevaKardex));
    }

    //ACTUALIZAR LAS KARDEXES EXISTENTES
    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<KardexDto> actualizarKardex(@PathVariable Long id, @RequestBody Kardex kardex) {
        if (kardexService.findById(id).isPresent()) {
            kardex.setKardexCod(id);
            Kardex kardexActualizada = kardexService.update(id, kardex);
            return ResponseEntity.ok(new KardexDto(kardexActualizada));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //EXTERMINAR KARDEXES 

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarKardex(@PathVariable Long id) {
        if (kardexService.findById(id).isPresent()) {
            kardexService.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }  


}
