package com.somic.pruebatecnica.domain.dto;

import java.time.LocalDate;

import com.somic.pruebatecnica.persistence.entities.Kardex;



public class KardexDto {

    private Long kardexCod;
    private  Long artCod;
    private Integer kardexUnd;
    private Boolean kardexNatu;
    private LocalDate kardexFecha;
    private Integer kardexSaldoAntes;
    private Integer kardexSaldoDespues;

    public KardexDto() {
    }

    public KardexDto(Kardex kardex) {
        this.kardexCod = kardex.getKardexCod();
        this.artCod = kardex.getArticulo() != null ? kardex.getArticulo().getArtCod() : null;
        this.kardexUnd = kardex.getKardexUnd();
        this.kardexNatu = kardex.getKardexNatu();
        this.kardexFecha = kardex.getKardexFecha();
        this.kardexSaldoAntes = kardex.getKardexSaldoAntes();
        this.kardexSaldoDespues = kardex.getKardexSaldoDespues();
    }

    public Long getKardexCod() {
        return kardexCod;
    }

    public void setKardexCod(Long kardexCod) {
        this.kardexCod = kardexCod;
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

    public LocalDate getKardexFecha() {
        return kardexFecha;
    }

    public void setKardexFecha(LocalDate kardexFecha) {
        this.kardexFecha = kardexFecha;
    }

    public Integer getKardexSaldoAntes() {
        return kardexSaldoAntes;
    }

    public void setKardexSaldoAntes(Integer kardexSaldoAntes) {
        this.kardexSaldoAntes = kardexSaldoAntes;
    }

    public Integer getKardexSaldoDespues() {
        return kardexSaldoDespues;
    }

    public void setKardexSaldoDespues(Integer kardexSaldoDespues) {
        this.kardexSaldoDespues = kardexSaldoDespues;
    }


    

    
}
