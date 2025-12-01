package com.ufg.garcomeletronico.controllers;

import com.ufg.garcomeletronico.entities.Restaurante;
import com.ufg.garcomeletronico.services.RestauranteService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/restaurantes")
public class RestauranteController {

    private final RestauranteService service;

    public RestauranteController(RestauranteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Restaurante> findAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public Restaurante findById(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public Restaurante create(@RequestBody Restaurante restaurante) { return service.create(restaurante); }

    @PutMapping("/{id}")
    public Restaurante update(@PathVariable Long id, @RequestBody Restaurante restaurante) {
        return service.update(id, restaurante);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
