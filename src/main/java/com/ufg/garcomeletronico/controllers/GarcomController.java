package com.ufg.garcomeletronico.controllers;

import com.ufg.garcomeletronico.entities.Garcom;
import com.ufg.garcomeletronico.services.GarcomService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/garcons")
public class GarcomController {

    private final GarcomService service;

    public GarcomController(GarcomService service) {
        this.service = service;
    }

    @GetMapping
    public List<Garcom> findAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public Garcom findById(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public Garcom create(@RequestBody Garcom garcom) { return service.create(garcom); }

    @PutMapping("/{id}")
    public Garcom update(@PathVariable Long id, @RequestBody Garcom garcom) {
        return service.update(id, garcom);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
