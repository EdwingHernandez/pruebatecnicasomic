package com.somic.pruebatecnica.domain.dto;

import com.somic.pruebatecnica.persistence.entities.Articulo;


public class ArticuloDto {

    private Long artCod;
    private String artNombre;
    private Long labCod;
    private Integer artSaldo;
    private Float artCosto;
    private Float artPrecioV;

    public ArticuloDto() {
    }

    public ArticuloDto(Articulo articulo) {
        this.artCod = articulo.getArtCod();
        this.artNombre = articulo.getArtNombre();
        this.labCod = articulo.getLaboratorio() != null ? articulo.getLaboratorio().getLabCod() : null;
        this.artSaldo = articulo.getArtSaldo();
        this.artCosto = articulo.getArtCosto();
        this.artPrecioV = articulo.getArtPrecioV();
    }

    public Long getArtCod() {
        return artCod;
    }

    public void setArtCod(Long artCod) {
        this.artCod = artCod;
    }

    public String getArtNombre() {
        return artNombre;
    }

    public void setArtNombre(String artNombre) {
        this.artNombre = artNombre;
    }

    public Long getLaboratorio() {
        return labCod;
    }

    public void setLaboratorio(Long labCod) {
        this.labCod = labCod;
    }

    public Integer getArtSaldo() {
        return artSaldo;
    }

    public void setArtSaldo(Integer artSaldo) {
        this.artSaldo = artSaldo;
    }

    public Float getArtCosto() {
        return artCosto;
    }

    public void setArtCosto(Float artCosto) {
        this.artCosto = artCosto;
    }

    public Float getArtPrecioV() {
        return artPrecioV;
    }

    public void setArtPrecioV(Float artPrecioV) {
        this.artPrecioV = artPrecioV;
    }

    
    

}
