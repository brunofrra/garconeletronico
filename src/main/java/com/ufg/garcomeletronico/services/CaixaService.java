package com.ufg.garcomeletronico.services;

import com.ufg.garcomeletronico.entities.*;
import com.ufg.garcomeletronico.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaixaService {

    @Autowired
    private CaixaRepository repository;

    public List<Caixa> findAll() {
        return repository.findAll();
    }

    public Caixa findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Caixa não encontrado"));
    }

    public Caixa create(Caixa obj) {
        return repository.save(obj);
    }

    public Caixa update(Long id, Caixa obj) {
        obj.setId(id);
        return repository.save(obj);
    }

    public void delete(Long id) {
        repository.delete(findById(id));
    }
}
