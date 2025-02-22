package com.somic.pruebatecnica.domain.dto;

import com.somic.pruebatecnica.persistence.entities.Facturakardex;


public class FacturakardexDto {

    private Long factuKardexCod;
    private Long factuCod;
    private Long kardexCod;

    public FacturakardexDto(Facturakardex facturakardex) {
        this.kardexCod = facturakardex.getFactuKardexCod();
        this.factuCod = facturakardex.getFactura() != null ? facturakardex.getFactura().getFactuCod() : null;
        this.kardexCod = facturakardex.getKardex() != null ? facturakardex.getKardex().getKardexCod() : null;
    }

    public Long getFactuKardexCod() {
        return factuKardexCod;
    }

    public void setFactuKardexCod(Long factuKardexCod) {
        this.factuKardexCod = factuKardexCod;
    }

    public Long getFactuCod() {
        return factuCod;
    }

    public void setFactuCod(Long factuCod) {
        this.factuCod = factuCod;
    }

    public Long getKardexCod() {
        return kardexCod;
    }

    public void setKardexCod(Long kardexCod) {
        this.kardexCod = kardexCod;
    }







}
