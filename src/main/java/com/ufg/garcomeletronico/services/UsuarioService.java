package com.ufg.garcomeletronico.services;

import com.ufg.garcomeletronico.entities.Usuario;
import com.ufg.garcomeletronico.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    // ============================= LISTAR =============================
    public List<Usuario> findAll() {
        return repository.findAll();
    }

    // ============================= BUSCAR =============================
    public Usuario findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public Usuario findByLogin(String login) {
        return repository.findByLogin(login)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado pelo login"));
    }

    // ============================= CRIAR =============================
    public Usuario create(Usuario obj) {
        if (obj == null) throw new IllegalArgumentException("Dados do usuário são obrigatórios");

        if (obj.getLogin() == null || obj.getLogin().isBlank())
            throw new RuntimeException("Login é obrigatório");

        // verificar duplicidade de login
        if (repository.existsByLogin(obj.getLogin())) {
            throw new RuntimeException("Já existe um usuário com esse login.");
        }

        return repository.save(obj);
    }

    // ============================= ATUALIZAR =============================
    public Usuario update(Long id, Usuario novosDados) {
        if (novosDados == null) throw new IllegalArgumentException("Dados do usuário são obrigatórios");

        Usuario existente = findById(id);

        // validar troca de login (não permitir trocar para um login já existente)
        String novoLogin = novosDados.getLogin();
        if (novoLogin != null && !novoLogin.isBlank() && !novoLogin.equals(existente.getLogin())) {
            if (repository.existsByLogin(novoLogin)) {
                throw new RuntimeException("Login já está em uso.");
            }
            existente.setLogin(novoLogin);
        }

        // atualizar nome se informado
        if (novosDados.getNome() != null && !novosDados.getNome().isBlank()) {
            existente.setNome(novosDados.getNome());
        }

        // alterar senha somente se preenchida
        if (novosDados.getSenha() != null && !novosDados.getSenha().isBlank()) {
            existente.setSenha(novosDados.getSenha());
        }

        // salvar as alterações (merge seguro)
        return repository.save(existente);
    }

    // ============================= DELETAR =============================
    public void delete(Long id) {
        Usuario u = findById(id);
        repository.delete(u);
    }
}
