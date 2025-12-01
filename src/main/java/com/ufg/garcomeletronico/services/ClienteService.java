package com.ufg.garcomeletronico.services;

import com.ufg.garcomeletronico.entities.*;
import com.ufg.garcomeletronico.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public List<Cliente> findAll() { return repository.findAll(); }
    public Cliente findById(Long id) { return repository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado")); }
    public Cliente create(Cliente obj) { return repository.save(obj); }
    public Cliente update(Long id, Cliente obj) { obj.setId(id); return repository.save(obj); }
    public void delete(Long id) { repository.delete(findById(id)); }
}