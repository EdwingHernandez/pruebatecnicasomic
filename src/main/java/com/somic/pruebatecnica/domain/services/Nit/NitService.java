package com.somic.pruebatecnica.domain.services.Nit;

import java.util.List;
import java.util.Optional;

import com.somic.pruebatecnica.persistence.entities.Nit;

public interface NitService {

    List<Nit> findAll();
    Optional<Nit> findById(String id);
    Nit save(Nit nit);
    Nit update(String id, Nit nit);
    Optional<Nit> delete(String id);
}
