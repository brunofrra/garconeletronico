package com.ufg.garcomeletronico.controllers;

import com.ufg.garcomeletronico.entities.Mesa;
import com.ufg.garcomeletronico.services.MesaService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/mesas")
public class MesaController {

    private final MesaService service;

    public MesaController(MesaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Mesa> findAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public Mesa findById(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public Mesa create(@RequestBody Mesa mesa) { return service.create(mesa); }

    @PutMapping("/{id}")
    public Mesa update(@PathVariable Long id, @RequestBody Mesa mesa) {
        return service.update(id, mesa);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
