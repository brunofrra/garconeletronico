package com.ufg.garcomeletronico.services;

import com.ufg.garcomeletronico.entities.*;
import com.ufg.garcomeletronico.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardapioService {

    @Autowired
    private CardapioRepository repository;

    public List<Cardapio> findAll() { return repository.findAll(); }
    public Cardapio findById(Long id) { return repository.findById(id).orElseThrow(() -> new RuntimeException("Cardápio não encontrado")); }
    public Cardapio create(Cardapio obj) { return repository.save(obj); }
    public Cardapio update(Long id, Cardapio obj) { obj.setId(id); return repository.save(obj); }
    public void delete(Long id) { repository.delete(findById(id)); }
}