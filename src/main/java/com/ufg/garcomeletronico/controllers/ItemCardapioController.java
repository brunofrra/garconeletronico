package com.ufg.garcomeletronico.controllers;

import com.ufg.garcomeletronico.entities.ItemCardapio;
import com.ufg.garcomeletronico.services.ItemCardapioService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/itens-cardapio")
public class ItemCardapioController {

    private final ItemCardapioService service;

    public ItemCardapioController(ItemCardapioService service) {
        this.service = service;
    }

    @GetMapping
    public List<ItemCardapio> findAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public ItemCardapio findById(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public ItemCardapio create(@RequestBody ItemCardapio item) { return service.create(item); }

    @PutMapping("/{id}")
    public ItemCardapio update(@PathVariable Long id, @RequestBody ItemCardapio item) {
        return service.update(id, item);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
