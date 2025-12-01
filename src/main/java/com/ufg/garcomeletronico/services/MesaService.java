package com.ufg.garcomeletronico.services;

import com.ufg.garcomeletronico.entities.Garcom;
import com.ufg.garcomeletronico.entities.Mesa;
import com.ufg.garcomeletronico.repositories.GarcomRepository;
import com.ufg.garcomeletronico.repositories.MesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MesaService {

    @Autowired
    private MesaRepository repository;

    @Autowired
    private GarcomRepository garcomRepository;

    // CRUD básico
    public List<Mesa> findAll() { return repository.findAll(); }

    public Mesa findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mesa não encontrada"));
    }

    public Mesa create(Mesa obj) { return repository.save(obj); }

    public Mesa update(Long id, Mesa obj) {
        obj.setId(id);
        return repository.save(obj);
    }

    public void delete(Long id) {
        repository.delete(findById(id));
    }


    // ============================
    // 🔵 ROTAS PERSONALIZADAS
    // ============================

    // Abrir mesa (por número)
    public Mesa abrirMesa(int numeroMesa) {
        Mesa mesa = repository.findByNumero(numeroMesa)
                .orElseThrow(() -> new RuntimeException("Mesa não encontrada"));

        if (!mesa.isDisponivel())
            throw new RuntimeException("Mesa já está ocupada");

        mesa.setDisponivel(false);
        return repository.save(mesa);
    }

    // Fechar mesa
    public Mesa fecharMesa(Long idMesa) {
        Mesa mesa = findById(idMesa);
        mesa.setDisponivel(true);
        mesa.setGarcom(null);
        return repository.save(mesa);
    }

    // Atribuir garçom
    public Mesa atribuirGarcom(Long idMesa, Long idGarcom) {
        Mesa mesa = findById(idMesa);
        Garcom garcom = garcomRepository.findById(idGarcom)
                .orElseThrow(() -> new RuntimeException("Garçom não encontrado"));

        mesa.setGarcom(garcom);
        mesa.setDisponivel(false);

        return repository.save(mesa);
    }

    // Liberar mesa sem fechar conta
    public Mesa liberarMesa(Long idMesa) {
        Mesa mesa = findById(idMesa);
        mesa.setGarcom(null);
        mesa.setDisponivel(true);
        return repository.save(mesa);
    }

    // Listar mesas disponíveis
    public List<Mesa> listarDisponiveis() {
        return repository.findByDisponivelTrue();
    }

    // Listar mesas ocupadas
    public List<Mesa> listarOcupadas() {
        return repository.findByDisponivelFalse();
    }
}
