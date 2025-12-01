package com.ufg.garcomeletronico.controllers;

import com.ufg.garcomeletronico.entities.Categoria;
import com.ufg.garcomeletronico.services.CategoriaService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    private final CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Categoria> findAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public Categoria findById(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public Categoria create(@RequestBody Categoria categoria) { return service.create(categoria); }

    @PutMapping("/{id}")
    public Categoria update(@PathVariable Long id, @RequestBody Categoria categoria) {
        return service.update(id, categoria);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
