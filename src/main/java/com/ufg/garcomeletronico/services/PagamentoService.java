package com.ufg.garcomeletronico.services;

import com.ufg.garcomeletronico.entities.*;
import com.ufg.garcomeletronico.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository repository;

    public List<Pagamento> findAll() { return repository.findAll(); }
    public Pagamento findById(Long id) { return repository.findById(id).orElseThrow(() -> new RuntimeException("Pagamento não encontrado")); }
    public Pagamento create(Pagamento obj) { return repository.save(obj); }
    public Pagamento update(Long id, Pagamento obj) { obj.setId(id); return repository.save(obj); }
    public void delete(Long id) { repository.delete(findById(id)); }
}