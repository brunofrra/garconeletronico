package com.ufg.garcomeletronico.controllers;

import com.ufg.garcomeletronico.entities.Cardapio;
import com.ufg.garcomeletronico.services.CardapioService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cardapios")
public class CardapioController {

    private final CardapioService service;

    public CardapioController(CardapioService service) {
        this.service = service;
    }

    @GetMapping
    public List<Cardapio> findAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public Cardapio findById(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public Cardapio create(@RequestBody Cardapio cardapio) { return service.create(cardapio); }

    @PutMapping("/{id}")
    public Cardapio update(@PathVariable Long id, @RequestBody Cardapio cardapio) {
        return service.update(id, cardapio);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
