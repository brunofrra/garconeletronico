package com.ufg.garcomeletronico.controllers;

import com.ufg.garcomeletronico.entities.Conta;
import com.ufg.garcomeletronico.services.ContaService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/contas")
public class ContaController {

    private final ContaService service;

    public ContaController(ContaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Conta> findAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public Conta findById(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public Conta create(@RequestBody Conta conta) { return service.create(conta); }

    @PutMapping("/{id}")
    public Conta update(@PathVariable Long id, @RequestBody Conta conta) {
        return service.update(id, conta);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
