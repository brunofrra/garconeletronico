package com.ufg.garcomeletronico.controllers;

import com.ufg.garcomeletronico.entities.Pedido;
import com.ufg.garcomeletronico.services.PedidoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Pedido> findAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public Pedido findById(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public Pedido create(@RequestBody Pedido pedido) { return service.create(pedido); }

    @PutMapping("/{id}")
    public Pedido update(@PathVariable Long id, @RequestBody Pedido pedido) {
        return service.update(id, pedido);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
