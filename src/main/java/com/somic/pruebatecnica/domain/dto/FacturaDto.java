package com.somic.pruebatecnica.domain.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.somic.pruebatecnica.persistence.entities.Factura;


public class FacturaDto {

    private Long factuCod;
    private Float factuTotal;
    private LocalDateTime factuFecha;
    private LocalDate factuVence;
    private String nitDocumento;
    
    public FacturaDto() {
    }

    public FacturaDto(Factura factura) {
        this.factuCod = factura.getFactuCod();
        this.factuTotal = factura.getFactuTotal();
        this.factuFecha = factura.getFactuFecha();
        this.factuVence = factura.getFactuVence();
        this.nitDocumento = factura.getNit() != null ? factura.getNit().getNitDocumento() : null;
    }

    public Long getFactuCod() {
        return factuCod;
    }

    public void setFactuCod(Long factuCod) {
        this.factuCod = factuCod;
    }

    public Float getFactuTotal() {
        return factuTotal;
    }

    public void setFactuTotal(Float factuTotal) {
        this.factuTotal = factuTotal;
    }

    public LocalDateTime getFactuFecha() {
        return factuFecha;
    }

    public void setFactuFecha(LocalDateTime factuFecha) {
        this.factuFecha = factuFecha;
    }

    public LocalDate getFactuVence() {
        return factuVence;
    }

    public void setFactuVence(LocalDate factuVence) {
        this.factuVence = factuVence;
    }

    public String getNit() {
        return nitDocumento;
    }

    public void setNit(String nitDocumento) {
        this.nitDocumento = nitDocumento;
    }


    
    
}
