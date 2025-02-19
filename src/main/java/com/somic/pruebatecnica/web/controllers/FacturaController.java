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

import com.somic.pruebatecnica.domain.dto.FacturaDto;
import com.somic.pruebatecnica.domain.services.Factura.FacturaService;
import com.somic.pruebatecnica.domain.services.Nit.NitService;
import com.somic.pruebatecnica.persistence.entities.Factura;

@RestController
@RequestMapping("/factura")
public class FacturaController {

    private final FacturaService facturaService;
    private final NitService nitService;

    public FacturaController(FacturaService facturaService, NitService nitService) {
        this.facturaService = facturaService;
        this.nitService = nitService;
    }

    //VER TODAS LAS FACTURAS 

    @GetMapping
    public ResponseEntity<List<FacturaDto>> listarFacturas() {
        List<Factura> facturas = facturaService.findAll();
        List<FacturaDto> facturaDTO = facturas.stream().map(FacturaDto::new).collect(Collectors.toList());
        return ResponseEntity.ok(facturaDTO);
    }

    //OBTENER UNA FACTURA ESPECIFICA POR SU ID

    @GetMapping("/{id}")
    public ResponseEntity<FacturaDto> obtenerFactura(@PathVariable Long id) {
        Optional<Factura> factura = facturaService.findById(id);
        return factura.map(c -> ResponseEntity.ok(new FacturaDto(c))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //CREAR NUEVAS FACTURAES AMIGO

    @PostMapping("/nuevo")
    public ResponseEntity<FacturaDto> crearFactura(@RequestBody Factura factura) {
        if (nitService.findById(factura.getNit().getNitDocumento()).isEmpty()) {
            return ResponseEntity.badRequest().build(); 
        }
        Factura nuevaFactura = facturaService.save(factura);
        return ResponseEntity.status(HttpStatus.CREATED).body(new FacturaDto(nuevaFactura));
    }

    //ACTUALIZAR LAS FACTURAES EXISTENTES
    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<FacturaDto> actualizarFactura(@PathVariable Long id, @RequestBody Factura factura) {
        if (facturaService.findById(id).isPresent()) {
            factura.setFactuCod(id);
            Factura facturaActualizada = facturaService.update(id, factura);
            return ResponseEntity.ok(new FacturaDto(facturaActualizada));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //EXTERMINAR FACTURAES 

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarFactura(@PathVariable Long id) {
        if (facturaService.findById(id).isPresent()) {
            facturaService.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }    

}
