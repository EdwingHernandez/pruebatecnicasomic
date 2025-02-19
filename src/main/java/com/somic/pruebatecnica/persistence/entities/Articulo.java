package com.somic.pruebatecnica.persistence.entities;

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
@Table(name = "articulo")
public class Articulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long artCod;
    private String artNombre;

    @ManyToOne
    @JoinColumn(name =  "labCod")
    private Laboratorio laboratorio;
    private Integer artSaldo;
    private Float artCosto;
    private Float artPrecioV;

    @OneToMany(mappedBy = "articulo")
    private List<Facturakardex> facturakardex;

    public Articulo() {
    }

    public Articulo(Long artCod, String artNombre, Laboratorio laboratorio, Integer artSaldo, Float artCosto,
            Float artPrecioV) {
        this.artCod = artCod;
        this.artNombre = artNombre;
        this.laboratorio = laboratorio;
        this.artSaldo = artSaldo;
        this.artCosto = artCosto;
        this.artPrecioV = artPrecioV;
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

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
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
