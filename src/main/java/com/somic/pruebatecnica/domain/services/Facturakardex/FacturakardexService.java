package com.somic.pruebatecnica.domain.services.Facturakardex;

import java.util.List;
import java.util.Optional;

import com.somic.pruebatecnica.persistence.entities.Facturakardex;

public interface FacturakardexService {

    List<Facturakardex> findAll();
    Optional<Facturakardex> findById(Long id);
    Facturakardex save(Facturakardex facturakardex);
    Facturakardex update(Long id, Facturakardex facturakardex);
    Optional<Facturakardex> delete(Long id);
}
