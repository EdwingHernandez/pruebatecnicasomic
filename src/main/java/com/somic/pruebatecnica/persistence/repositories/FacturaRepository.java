package com.somic.pruebatecnica.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.somic.pruebatecnica.persistence.entities.Factura;


@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long>{

    @Query("SELECT SUM(f.factuTotal) FROM Factura f WHERE f.nit.nitDocumento = :nitDocumento")
    Double obtenerTotalFacturasPorCliente(@Param("nitDocumento") String nitDocumento);

}
