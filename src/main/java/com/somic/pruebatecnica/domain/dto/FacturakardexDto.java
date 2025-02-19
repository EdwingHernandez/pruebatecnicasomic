package com.somic.pruebatecnica.domain.dto;

import com.somic.pruebatecnica.persistence.entities.Facturakardex;


public class FacturakardexDto {

    private Long kardexCod;
    private Long factuCod;
    private Long artCod;
    private Integer kardexUnd;
    private Boolean kardexNatu;

    public FacturakardexDto(Facturakardex facturakardex) {
        this.kardexCod = facturakardex.getKardexCod();
        this.factuCod = facturakardex.getFactura() != null ? facturakardex.getFactura().getFactuCod() : null;
        this.artCod = facturakardex.getArticulo() != null ? facturakardex.getArticulo().getArtCod() : null;
        this.kardexUnd = facturakardex.getKardexUnd();
        this.kardexNatu = facturakardex.getKardexNatu();
    }

    public Long getKardexCod() {
        return kardexCod;
    }

    public void setKardexCod(Long kardexCod) {
        this.kardexCod = kardexCod;
    }

    public Long getFactuCod() {
        return factuCod;
    }

    public void setFactuCod(Long factuCod) {
        this.factuCod = factuCod;
    }

    public Long getArtCod() {
        return artCod;
    }

    public void setArtCod(Long artCod) {
        this.artCod = artCod;
    }

    public Integer getKardexUnd() {
        return kardexUnd;
    }

    public void setKardexUnd(Integer kardexUnd) {
        this.kardexUnd = kardexUnd;
    }

    public Boolean getKardexNatu() {
        return kardexNatu;
    }

    public void setKardexNatu(Boolean kardexNatu) {
        this.kardexNatu = kardexNatu;
    }





}
