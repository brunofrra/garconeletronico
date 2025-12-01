package com.ufg.garcomeletronico.controllers;

import com.ufg.garcomeletronico.entities.Pagamento;
import com.ufg.garcomeletronico.services.PagamentoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pagamentos")
public class PagamentoController {

    private final PagamentoService service;

    public PagamentoController(PagamentoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Pagamento> findAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public Pagamento findById(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public Pagamento create(@RequestBody Pagamento pagamento) { return service.create(pagamento); }

    @PutMapping("/{id}")
    public Pagamento update(@PathVariable Long id, @RequestBody Pagamento pagamento) {
        return service.update(id, pagamento);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
