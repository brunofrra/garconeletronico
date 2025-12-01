package com.ufg.garcomeletronico.controllers;

import com.ufg.garcomeletronico.entities.Gerente;
import com.ufg.garcomeletronico.services.GerenteService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/gerentes")
public class GerenteController {

    private final GerenteService service;

    public GerenteController(GerenteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Gerente> findAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public Gerente findById(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public Gerente create(@RequestBody Gerente gerente) { return service.create(gerente); }

    @PutMapping("/{id}")
    public Gerente update(@PathVariable Long id, @RequestBody Gerente gerente) {
        return service.update(id, gerente);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
