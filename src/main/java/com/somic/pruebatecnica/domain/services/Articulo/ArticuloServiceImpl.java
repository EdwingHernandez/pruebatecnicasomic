package com.somic.pruebatecnica.domain.services.Articulo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.somic.pruebatecnica.persistence.entities.Articulo;
import com.somic.pruebatecnica.persistence.repositories.ArticuloRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class ArticuloServiceImpl implements ArticuloService {

    @Autowired
    private final ArticuloRepository articuloRepository;

    public ArticuloServiceImpl(ArticuloRepository articuloRepository) {
        this.articuloRepository = articuloRepository;
    }

    @Override
    public List<Articulo> findAll() {
        return (List<Articulo>) articuloRepository.findAll();
    }

    @Override
    public Optional<Articulo> findById(Long id) {
        return articuloRepository.findById(id);
    }

    @Override
    public Articulo save(Articulo articulo) {
        return articuloRepository.save(articulo);
    }

    @Override
    @Transactional
    public Articulo update(Long id, Articulo articulo) {
        if (!articuloRepository.existsById(id)) {
            throw new EntityNotFoundException("Articulo no encontrado con id " + id);
        }
        articulo.setArtCod(id);
        return articuloRepository.save(articulo);
    }

    @Override
    @Transactional
    public Optional<Articulo> delete(Long id) {
        Optional<Articulo> articulo = articuloRepository.findById(id);
        if (articulo.isPresent()) {
            articuloRepository.deleteById(id);
        }
        return articulo;
    }

}
