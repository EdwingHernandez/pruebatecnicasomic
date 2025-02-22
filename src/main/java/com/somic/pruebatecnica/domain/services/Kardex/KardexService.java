package com.somic.pruebatecnica.domain.services.Kardex;

import java.util.List;
import java.util.Optional;

import com.somic.pruebatecnica.persistence.entities.Kardex;

public interface KardexService {

    List<Kardex> findAll();
    Optional<Kardex> findById(Long id);
    Kardex save(Kardex kardex);
    Kardex update(Long id, Kardex kardex);
    Optional<Kardex> delete(Long id);
}
