package com.somic.pruebatecnica.domain.services.Laboratorio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.somic.pruebatecnica.persistence.entities.Laboratorio;
import com.somic.pruebatecnica.persistence.repositories.LaboratorioRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class LaboratorioServiceImpl implements LaboratorioService{

    @Autowired
    private final LaboratorioRepository laboratorioRepository;

    public LaboratorioServiceImpl(LaboratorioRepository laboratorioRepository) {
        this.laboratorioRepository = laboratorioRepository;
    }

    @Override
    public List<Laboratorio> findAll() {
        return (List<Laboratorio>) laboratorioRepository.findAll();
    }

    @Override
    public Optional<Laboratorio> findById(Long id) {
        return laboratorioRepository.findById(id);
    }

    @Override
    public Laboratorio save(Laboratorio laboratorio) {
        return laboratorioRepository.save(laboratorio);
    }

    @Override
    @Transactional
    public Laboratorio update(Long id, Laboratorio laboratorio) {
        if (!laboratorioRepository.existsById(id)) {
            throw new EntityNotFoundException("Laboratorio no encontrada con id " + id);
        }
        laboratorio.setLabCod(id); 
        return laboratorioRepository.save(laboratorio);
    }

    @Override
    @Transactional
    public Optional<Laboratorio> delete(Long id) {
        Optional<Laboratorio> laboratorio = laboratorioRepository.findById(id);
        if (laboratorio.isPresent()) {
            laboratorioRepository.deleteById(id);
        }
        return laboratorio;
    }    

}
