package com.somic.pruebatecnica.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "nit")
public class Nit {

    @Id
    private String nitDocumento;
    private String nitNombre;
    private Integer nitCupo;
    private Integer nitPlazo;

    public Nit(){

    }

    public Nit(String nitDocumento, String nitNombre, Integer nitCupo, Integer nitPlazo) {
        this.nitDocumento = nitDocumento;
        this.nitNombre = nitNombre;
        this.nitCupo = nitCupo;
        this.nitPlazo = nitPlazo;
    }

    public String getNitDocumento() {
        return nitDocumento;
    }

    public void setNitDocumento(String nitDocumento) {
        this.nitDocumento = nitDocumento;
    }

    public String getNitNombre() {
        return nitNombre;
    }

    public void setNitNombre(String nitNombre) {
        this.nitNombre = nitNombre;
    }

    public Integer getNitCupo() {
        return nitCupo;
    }

    public void setNitCupo(Integer nitCupo) {
        this.nitCupo = nitCupo;
    }

    public Integer getNitPlazo() {
        return nitPlazo;
    }

    public void setNitPlazo(Integer nitPlazo) {
        this.nitPlazo = nitPlazo;
    }



}
