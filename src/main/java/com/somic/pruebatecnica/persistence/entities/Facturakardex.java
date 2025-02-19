package com.somic.pruebatecnica.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "facturaKardex")
public class Facturakardex {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long kardexCod;


    @ManyToOne
    @JoinColumn(name = "factuCod")
    private Factura factura;


    @ManyToOne
    @JoinColumn(name = "artCod")
    private Articulo articulo;


    private Integer kardexUnd;
    private Boolean kardexNatu;

    public Facturakardex() {
    }

    public Facturakardex(Long kardexCod, Factura factura, Articulo articulo, Integer kardexUnd, Boolean kardexNatu) {
        this.kardexCod = kardexCod;
        this.factura = factura;
        this.articulo = articulo;
        this.kardexUnd = kardexUnd;
        this.kardexNatu = kardexNatu;
    }

    public Long getKardexCod() {
        return kardexCod;
    }

    public void setKardexCod(Long kardexCod) {
        this.kardexCod = kardexCod;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
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
