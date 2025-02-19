package com.somic.pruebatecnica.domain.services.Nit;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.somic.pruebatecnica.persistence.entities.Nit;
import com.somic.pruebatecnica.persistence.repositories.NitRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class NitServiceImpl implements NitService{

    @Autowired
    private final NitRepository nitRepository;

    public NitServiceImpl(NitRepository nitRepository) {
        this.nitRepository = nitRepository;
    }

    @Override
    public List<Nit> findAll() {
        return (List<Nit>) nitRepository.findAll();
    }

    @Override
    public Optional<Nit> findById(String id) {
        return nitRepository.findById(id);
    }

    @Override
    public Nit save(Nit nit) {
        return nitRepository.save(nit);
    }

    @Override
    @Transactional
    public Nit update(String id, Nit nit) {
        if (!nitRepository.existsById(id)) {
            throw new EntityNotFoundException("Nit no encontrada con id " + id);
        }
        nit.setNitDocumento(id); 
        return nitRepository.save(nit);
    }

    @Override
    @Transactional
    public Optional<Nit> delete(String id) {
        Optional<Nit> nit = nitRepository.findById(id);
        if (nit.isPresent()) {
            nitRepository.deleteById(id);
        }
        return nit;
    }    

}
