package com.somic.pruebatecnica.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.somic.pruebatecnica.persistence.entities.Factura;


@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long>{

}
