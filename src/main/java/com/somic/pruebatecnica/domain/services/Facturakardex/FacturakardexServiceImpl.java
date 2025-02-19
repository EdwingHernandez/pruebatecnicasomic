package com.somic.pruebatecnica.domain.services.Facturakardex;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.somic.pruebatecnica.persistence.entities.Facturakardex;
import com.somic.pruebatecnica.persistence.repositories.FacturakardexRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class FacturakardexServiceImpl implements FacturakardexService{

    @Autowired
    private final FacturakardexRepository facturakardexRepository;

    public FacturakardexServiceImpl(FacturakardexRepository facturakardexRepository) {
        this.facturakardexRepository = facturakardexRepository;
    }

    @Override
    public List<Facturakardex> findAll() {
        return (List<Facturakardex>) facturakardexRepository.findAll();
    }

    @Override
    public Optional<Facturakardex> findById(Long id) {
        return facturakardexRepository.findById(id);
    }

    @Override
    public Facturakardex save(Facturakardex facturakardex) {
        return facturakardexRepository.save(facturakardex);
    }

    @Override
    @Transactional
    public Facturakardex update(Long id, Facturakardex facturakardex) {
        if (!facturakardexRepository.existsById(id)) {
            throw new EntityNotFoundException("Facturakardex no encontrada con id " + id);
        }
        facturakardex.setKardexCod(id); 
        return facturakardexRepository.save(facturakardex);
    }

    @Override
    @Transactional
    public Optional<Facturakardex> delete(Long id) {
        Optional<Facturakardex> facturakardex = facturakardexRepository.findById(id);
        if (facturakardex.isPresent()) {
            facturakardexRepository.deleteById(id);
        }
        return facturakardex;
    }    

}
