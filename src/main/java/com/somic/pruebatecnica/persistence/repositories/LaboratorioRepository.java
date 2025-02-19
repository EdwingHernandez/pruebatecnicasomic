package com.somic.pruebatecnica.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.somic.pruebatecnica.persistence.entities.Laboratorio;

@Repository
public interface LaboratorioRepository extends JpaRepository<Laboratorio, Long>{

}
