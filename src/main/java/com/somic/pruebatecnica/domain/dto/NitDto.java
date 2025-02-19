package com.somic.pruebatecnica.domain.dto;


import com.somic.pruebatecnica.persistence.entities.Nit;

public class NitDto {

    private String nitDocumento;
    private String nitNombre;
    private Integer nitCupo;
    private Integer nitPlazo;


    public NitDto(Nit nit) {
        this.nitDocumento = nit.getNitDocumento();
        this.nitNombre = nit.getNitNombre();
        this.nitCupo = nit.getNitCupo();
        this.nitPlazo = nit.getNitPlazo();
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
