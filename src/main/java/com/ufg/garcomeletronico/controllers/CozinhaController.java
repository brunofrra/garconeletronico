package com.ufg.garcomeletronico.controllers;

import com.ufg.garcomeletronico.entities.Cozinha;
import com.ufg.garcomeletronico.services.CozinhaService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cozinhas")
public class CozinhaController {

    private final CozinhaService service;

    public CozinhaController(CozinhaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Cozinha> findAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public Cozinha findById(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public Cozinha create(@RequestBody Cozinha cozinha) { return service.create(cozinha); }

    @PutMapping("/{id}")
    public Cozinha update(@PathVariable Long id, @RequestBody Cozinha cozinha) {
        return service.update(id, cozinha);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
