package com.ufg.garcomeletronico.services;

import com.ufg.garcomeletronico.entities.*;
import com.ufg.garcomeletronico.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemCardapioService {

    @Autowired
    private ItemCardapioRepository repository;

    public List<ItemCardapio> findAll() { return repository.findAll(); }
    public ItemCardapio findById(Long id) { return repository.findById(id).orElseThrow(() -> new RuntimeException("Item não encontrado")); }
    public ItemCardapio create(ItemCardapio obj) { return repository.save(obj); }
    public ItemCardapio update(Long id, ItemCardapio obj) { obj.setId(id); return repository.save(obj); }
    public void delete(Long id) { repository.delete(findById(id)); }
}