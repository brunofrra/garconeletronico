package com.ufg.garcomeletronico.controllers;

import com.ufg.garcomeletronico.entities.ItemPedido;
import com.ufg.garcomeletronico.services.ItemPedidoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/itens-pedido")
public class ItemPedidoController {

    private final ItemPedidoService service;

    public ItemPedidoController(ItemPedidoService service) {
        this.service = service;
    }

    @GetMapping
    public List<ItemPedido> findAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public ItemPedido findById(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public ItemPedido create(@RequestBody ItemPedido item) { return service.create(item); }

    @PutMapping("/{id}")
    public ItemPedido update(@PathVariable Long id, @RequestBody ItemPedido item) {
        return service.update(id, item);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
