package com.somic.pruebatecnica.domain.services.Kardex;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.somic.pruebatecnica.persistence.entities.Kardex;
import com.somic.pruebatecnica.persistence.repositories.KardexRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class KardexServiceImpl implements KardexService{

    @Autowired
    private final KardexRepository kardexRepository;

    public KardexServiceImpl(KardexRepository kardexRepository) {
        this.kardexRepository = kardexRepository;
    }

    @Override
    public List<Kardex> findAll() {
        return (List<Kardex>) kardexRepository.findAll();
    }

    @Override
    public Optional<Kardex> findById(Long id) {
        return kardexRepository.findById(id);
    }

    @Override
    public Kardex save(Kardex kardex) {
        return kardexRepository.save(kardex);
    }

    @Override
    @Transactional
    public Kardex update(Long id, Kardex kardex) {
        if (!kardexRepository.existsById(id)) {
            throw new EntityNotFoundException("Kardex no encontrado con id " + id);
        }
        kardex.setKardexCod(id);
        return kardexRepository.save(kardex);
    }

    @Override
    @Transactional
    public Optional<Kardex> delete(Long id) {
        Optional<Kardex> kardex = kardexRepository.findById(id);
        if (kardex.isPresent()) {
            kardexRepository.deleteById(id);
        }
        return kardex;
    }

    
}
