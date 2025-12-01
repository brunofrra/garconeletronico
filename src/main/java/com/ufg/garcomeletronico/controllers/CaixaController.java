package com.ufg.garcomeletronico.controllers;

import com.ufg.garcomeletronico.entities.Caixa;
import com.ufg.garcomeletronico.services.CaixaService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/caixas")
public class CaixaController {

    private final CaixaService service;

    public CaixaController(CaixaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Caixa> findAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public Caixa findById(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public Caixa create(@RequestBody Caixa caixa) { return service.create(caixa); }

    @PutMapping("/{id}")
    public Caixa update(@PathVariable Long id, @RequestBody Caixa caixa) {
        return service.update(id, caixa);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
