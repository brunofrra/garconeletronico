package com.ufg.garcomeletronico.services;

import com.ufg.garcomeletronico.entities.*;
import com.ufg.garcomeletronico.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CozinhaService {

    @Autowired
    private CozinhaRepository repository;

    public List<Cozinha> findAll() { return repository.findAll(); }
    public Cozinha findById(Long id) { return repository.findById(id).orElseThrow(() -> new RuntimeException("Cozinha não encontrada")); }
    public Cozinha create(Cozinha obj) { return repository.save(obj); }
    public Cozinha update(Long id, Cozinha obj) { obj.setId(id); return repository.save(obj); }
    public void delete(Long id) { repository.delete(findById(id)); }
}