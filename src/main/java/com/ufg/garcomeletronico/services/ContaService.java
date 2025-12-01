package com.ufg.garcomeletronico.services;

import com.ufg.garcomeletronico.entities.*;
import com.ufg.garcomeletronico.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaService {

    @Autowired
    private ContaRepository repository;

    public List<Conta> findAll() { return repository.findAll(); }
    public Conta findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Conta não encontrada"));
    }
    public Conta create(Conta obj) { return repository.save(obj); }
    public Conta update(Long id, Conta obj) { obj.setId(id); return repository.save(obj); }
    public void delete(Long id) { repository.delete(findById(id)); }
}