package com.somic.pruebatecnica.domain.services.Factura;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.somic.pruebatecnica.persistence.entities.Factura;
import com.somic.pruebatecnica.persistence.repositories.FacturaRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class FacturaServiceImpl implements FacturaService{

    @Autowired
    private final FacturaRepository facturaRepository;


    @Override
    public Double obtenerTotalFacturas(String nitCod) {
        Double total = facturaRepository.obtenerTotalFacturasPorCliente(nitCod);
        return (total != null) ? total : 0.0;
    }


    public FacturaServiceImpl(FacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }

    @Override
    public List<Factura> findAll() {
        return (List<Factura>) facturaRepository.findAll();
    }

    @Override
    public Optional<Factura> findById(Long id) {
        return facturaRepository.findById(id);
    }

    @Override
    public Factura save(Factura factura) {
        return facturaRepository.save(factura);
    }

    @Override
    @Transactional
    public Factura update(Long id, Factura factura) {
        if (!facturaRepository.existsById(id)) {
            throw new EntityNotFoundException("Factura no encontrada con id " + id);
        }
        factura.setFactuCod(id); 
        return facturaRepository.save(factura);
    }

    @Override
    @Transactional
    public Optional<Factura> delete(Long id) {
        Optional<Factura> factura = facturaRepository.findById(id);
        if (factura.isPresent()) {
            facturaRepository.deleteById(id);
        }
        return factura;
    }    

}
