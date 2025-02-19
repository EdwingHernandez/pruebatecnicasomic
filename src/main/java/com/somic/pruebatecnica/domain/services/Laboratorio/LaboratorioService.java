package com.somic.pruebatecnica.domain.services.Laboratorio;

import java.util.List;
import java.util.Optional;

import com.somic.pruebatecnica.persistence.entities.Laboratorio;

public interface LaboratorioService {

    List<Laboratorio> findAll();
    Optional<Laboratorio> findById(Long id);
    Laboratorio save(Laboratorio laboratorio);
    Laboratorio update(Long id, Laboratorio laboratorio);
    Optional<Laboratorio> delete(Long id);
}
