package com.ufg.garcomeletronico.controllers;

import com.ufg.garcomeletronico.entities.Cliente;
import com.ufg.garcomeletronico.services.ClienteService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Cliente> findAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public Cliente findById(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public Cliente create(@RequestBody Cliente cliente) { return service.create(cliente); }

    @PutMapping("/{id}")
    public Cliente update(@PathVariable Long id, @RequestBody Cliente cliente) {
        return service.update(id, cliente);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
