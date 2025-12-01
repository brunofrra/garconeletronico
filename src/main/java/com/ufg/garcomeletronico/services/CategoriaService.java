package com.ufg.garcomeletronico.services;

import com.ufg.garcomeletronico.entities.*;
import com.ufg.garcomeletronico.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public List<Categoria> findAll() { return repository.findAll(); }
    public Categoria findById(Long id) { return repository.findById(id).orElseThrow(() -> new RuntimeException("Categoria não encontrada")); }
    public Categoria create(Categoria obj) { return repository.save(obj); }
    public Categoria update(Long id, Categoria obj) { obj.setId(id); return repository.save(obj); }
    public void delete(Long id) { repository.delete(findById(id)); }
}