package com.somic.pruebatecnica.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "laboratorio")
public class Laboratorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long labCod;
    
    private String labNombre;

    public Laboratorio() {
    }

    public Laboratorio(Long labCod, String labNombre) {
        this.labCod = labCod;
        this.labNombre = labNombre;
    }

    public Long getLabCod() {
        return labCod;
    }

    public void setLabCod(Long labCod) {
        this.labCod = labCod;
    }

    public String getLabNombre() {
        return labNombre;
    }

    public void setLabNombre(String labNombre) {
        this.labNombre = labNombre;
    }

    
    
    
     
}
