package com.ufg.garcomeletronico.services;

import com.ufg.garcomeletronico.entities.*;
import com.ufg.garcomeletronico.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    public List<Pedido> findAll() { return repository.findAll(); }
    public Pedido findById(Long id) { return repository.findById(id).orElseThrow(() -> new RuntimeException("Pedido não encontrado")); }
    public Pedido create(Pedido obj) { return repository.save(obj); }
    public Pedido update(Long id, Pedido obj) { obj.setId(id); return repository.save(obj); }
    public void delete(Long id) { repository.delete(findById(id)); }
}