package com.somic.pruebatecnica.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "factura_kardex")
public class Facturakardex {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long factuKardexCod;


    @ManyToOne
    @JoinColumn(name = "factuCod")
    private Factura factura;


    @ManyToOne
    @JoinColumn(name = "kardexCod")
    private Kardex kardex;


    public Facturakardex() {
    }

    public Facturakardex(Long factuKardexCod, Factura factura, Kardex kardex, Integer kardexUnd, Boolean kardexNatu) {
        this.factuKardexCod = factuKardexCod;
        this.factura = factura;
        this.kardex = kardex;
    }

    public Long getFactuKardexCod() {
        return factuKardexCod;
    }

    public void setFactuKardexCod(Long factuKardexCod) {
        this.factuKardexCod = factuKardexCod;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Kardex getKardex() {
        return kardex;
    }

    public void setKardex(Kardex kardex) {
        this.kardex = kardex;
    }
    
    

}
