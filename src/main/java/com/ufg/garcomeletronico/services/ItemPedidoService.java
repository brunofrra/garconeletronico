package com.ufg.garcomeletronico.services;

import com.ufg.garcomeletronico.entities.*;
import com.ufg.garcomeletronico.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemPedidoService {

    @Autowired
    private ItemPedidoRepository repository;

    public List<ItemPedido> findAll() { return repository.findAll(); }
    public ItemPedido findById(Long id) { return repository.findById(id).orElseThrow(() -> new RuntimeException("Item do Pedido não encontrado")); }
    public ItemPedido create(ItemPedido obj) { return repository.save(obj); }
    public ItemPedido update(Long id, ItemPedido obj) { obj.setId(id); return repository.save(obj); }
    public void delete(Long id) { repository.delete(findById(id)); }
}