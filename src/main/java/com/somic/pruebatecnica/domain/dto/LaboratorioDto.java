package com.somic.pruebatecnica.domain.dto;

import com.somic.pruebatecnica.persistence.entities.Laboratorio;

public class LaboratorioDto {

    private Long labCod;
    private String labNombre;

    public LaboratorioDto(Laboratorio laboratorio) {

        this.labCod = laboratorio.getLabCod();
        this.labNombre = laboratorio.getLabNombre();
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
