package com.ufg.garcomeletronico.services;

import com.ufg.garcomeletronico.entities.*;
import com.ufg.garcomeletronico.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository repository;

    public List<Restaurante> findAll() { return repository.findAll(); }
    public Restaurante findById(Long id) { return repository.findById(id).orElseThrow(() -> new RuntimeException("Restaurante não encontrado")); }
    public Restaurante create(Restaurante obj) { return repository.save(obj); }
    public Restaurante update(Long id, Restaurante obj) { obj.setId(id); return repository.save(obj); }
    public void delete(Long id) { repository.delete(findById(id)); }
}