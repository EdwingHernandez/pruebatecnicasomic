package com.somic.pruebatecnica.domain.services.Factura;

import java.util.List;
import java.util.Optional;

import com.somic.pruebatecnica.persistence.entities.Factura;

public interface FacturaService {

    List<Factura> findAll();
    Optional<Factura> findById(Long id);
    Factura save(Factura factura);
    Factura update(Long id, Factura factura);
    Optional<Factura> delete(Long id);
}
