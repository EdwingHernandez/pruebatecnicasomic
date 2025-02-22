package com.somic.pruebatecnica.web.controllers;

import java.util.List;
import java.util.Optional;
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

import com.somic.pruebatecnica.domain.dto.FacturakardexDto;
import com.somic.pruebatecnica.domain.services.Facturakardex.FacturakardexService;
import com.somic.pruebatecnica.domain.services.Articulo.ArticuloService;
import com.somic.pruebatecnica.domain.services.Factura.FacturaService;
import com.somic.pruebatecnica.persistence.entities.Facturakardex;

@RestController
@RequestMapping("/facturakardex")
public class FacturakardexController {

    private final FacturakardexService facturakardexService;
    private final FacturaService facturaService;
    private final ArticuloService articuloService;

    public FacturakardexController(FacturakardexService facturakardexService, FacturaService facturaService, ArticuloService articuloService) {
        this.facturakardexService = facturakardexService;
        this.facturaService = facturaService;
        this.articuloService = articuloService;
    }

    //VER TODAS LAS FACTURAKARDEXS 

    @GetMapping
    public ResponseEntity<List<FacturakardexDto>> listarFacturakardexs() {
        List<Facturakardex> facturakardexs = facturakardexService.findAll();
        List<FacturakardexDto> facturakardexesDTO = facturakardexs.stream().map(FacturakardexDto::new).collect(Collectors.toList());
        return ResponseEntity.ok(facturakardexesDTO);
    }

    //OBTENER UNA FACTURAKARDEX ESPECIFICA POR SU ID

    @GetMapping("/{id}")
    public ResponseEntity<FacturakardexDto> obtenerFacturakardex(@PathVariable Long id) {
        Optional<Facturakardex> facturakardex = facturakardexService.findById(id);
        return facturakardex.map(c -> ResponseEntity.ok(new FacturakardexDto(c))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //CREAR NUEVAS FACTURAKARDEXES AMIGO

    @PostMapping("/nuevo")
    public ResponseEntity<FacturakardexDto> crearFacturakardex(@RequestBody Facturakardex facturakardex) {
        if (facturaService.findById(facturakardex.getFactura().getFactuCod()).isEmpty() || articuloService.findById(facturakardex.getKardex().getKardexCod()).isEmpty()) {
            return ResponseEntity.badRequest().build(); 
        }
        Facturakardex nuevaFacturakardex = facturakardexService.save(facturakardex);
        return ResponseEntity.status(HttpStatus.CREATED).body(new FacturakardexDto(nuevaFacturakardex));
    }

    //ACTUALIZAR LAS FACTURAKARDEXES EXISTENTES
    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<FacturakardexDto> actualizarFacturakardex(@PathVariable Long id, @RequestBody Facturakardex facturakardex) {
        if (facturakardexService.findById(id).isPresent()) {
            facturakardex.setFactuKardexCod(id);
            Facturakardex facturakardexActualizada = facturakardexService.update(id, facturakardex);
            return ResponseEntity.ok(new FacturakardexDto(facturakardexActualizada));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //EXTERMINAR FACTURAKARDEXES 

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarFacturakardex(@PathVariable Long id) {
        if (facturakardexService.findById(id).isPresent()) {
            facturakardexService.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }    

    
}
