package com.ufg.garcomeletronico.services;

import com.ufg.garcomeletronico.entities.*;
import com.ufg.garcomeletronico.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GerenteService {

    @Autowired
    private GerenteRepository repository;

    public List<Gerente> findAll() { return repository.findAll(); }
    public Gerente findById(Long id) { return repository.findById(id).orElseThrow(() -> new RuntimeException("Gerente não encontrado")); }
    public Gerente create(Gerente obj) { return repository.save(obj); }
    public Gerente update(Long id, Gerente obj) { obj.setId(id); return repository.save(obj); }
    public void delete(Long id) { repository.delete(findById(id)); }
}