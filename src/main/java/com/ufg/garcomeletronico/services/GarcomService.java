package com.ufg.garcomeletronico.services;

import com.ufg.garcomeletronico.entities.*;
import com.ufg.garcomeletronico.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GarcomService {

    @Autowired
    private GarcomRepository repository;

    public List<Garcom> findAll() { return repository.findAll(); }
    public Garcom findById(Long id) { return repository.findById(id).orElseThrow(() -> new RuntimeException("Garçom não encontrado")); }
    public Garcom create(Garcom obj) { return repository.save(obj); }
    public Garcom update(Long id, Garcom obj) { obj.setId(id); return repository.save(obj); }
    public void delete(Long id) { repository.delete(findById(id)); }
}