package com.somic.pruebatecnica.persistence.entities;


import java.time.LocalDate;
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
@Table(name = "Kardex")
public class Kardex {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long kardexCod;

    @ManyToOne
    @JoinColumn(name = "artCod")
    private Articulo articulo;

    private Integer kardexUnd;
    private Boolean kardexNatu;
    private LocalDate kardexFecha;
    private Integer kardexSaldoAntes;
    private Integer kardexSaldoDespues;

    @OneToMany(mappedBy = "kardex")
    private List<Facturakardex> facturakardex;

    public Kardex(Long kardexCod, Articulo articulo, Integer kardexUnd, Boolean kardexNatu, LocalDate kardexFecha,
            Integer kardexSaldoAntes, Integer kardexSaldoDespues) {
        this.kardexCod = kardexCod;
        this.articulo = articulo;
        this.kardexUnd = kardexUnd;
        this.kardexNatu = kardexNatu;
        this.kardexFecha = kardexFecha;
        this.kardexSaldoAntes = kardexSaldoAntes;
        this.kardexSaldoDespues = kardexSaldoDespues;
    }

    public Long getKardexCod() {
        return kardexCod;
    }

    public void setKardexCod(Long kardexCod) {
        this.kardexCod = kardexCod;
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
