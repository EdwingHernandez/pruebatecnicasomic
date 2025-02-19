package com.somic.pruebatecnica.domain.services.Articulo;

import java.util.List;
import java.util.Optional;

import com.somic.pruebatecnica.persistence.entities.Articulo;

public interface ArticuloService {

    List<Articulo> findAll();
    Optional<Articulo> findById(Long id);
    Articulo save(Articulo articulo);
    Articulo update(Long id, Articulo articulo);
    Optional<Articulo> delete(Long id);

}
