package com.somic.pruebatecnica.persistence.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "factura")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long factuCod;
    private Float factuTotal;
    private LocalDateTime factuFecha;
    private LocalDate factuVence;

    @ManyToOne
    @JoinColumn(name = "nitDocumento")
    private Nit nit;

    @OneToMany(mappedBy = "factura")
    private List<Facturakardex> facturakardex;

    public Factura() {
    }

    public Factura(Long factuCod, Float factuTotal, LocalDateTime factuFecha, LocalDate factuVence, Nit nit) {
        this.factuCod = factuCod;
        this.factuTotal = factuTotal;
        this.factuFecha = factuFecha;
        this.factuVence = factuVence;
        this.nit = nit;
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

    public Nit getNit() {
        return nit;
    }

    public void setNit(Nit nit) {
        this.nit = nit;
    }


    

}
