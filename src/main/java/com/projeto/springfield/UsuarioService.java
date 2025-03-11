package com.projeto.springfield;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    public Usuario cadastrarUsuario(Usuario usuario) {
        if (repository.existsById(usuario.getId())) {
            throw new RuntimeException("Já existe um usuário cadastrado com este ID.");
        }
        return repository.save(usuario);
    }

    public Optional<Usuario> buscarPorUsername(String username) {
        return repository.findByUsername(username);
    }

    public void bloquearUsuario(int id) {
        repository.findById(id).ifPresent(usuario -> {
            usuario.setBloqueado(true);
            repository.save(usuario);
        });
    }

    public void desbloquearUsuario(int id) {
        repository.findById(id).ifPresent(usuario -> {
            usuario.setBloqueado(false);
            usuario.setTentativasLogin(0);
            repository.save(usuario);
        });
    }

    public void atualizarSenha(int id, String novaSenha) {
        repository.findById(id).ifPresent(usuario -> {
            usuario.setSenha(novaSenha);
            usuario.setSenhaExpirada(false);
            repository.save(usuario);
        });
    }

    public void registrarLogin(int id) {
        repository.findById(id).ifPresent(usuario -> {
            usuario.setUltimoLogin(LocalDate.now());
            usuario.setTentativasLogin(0);
            repository.save(usuario);
        });
    }

    public void incrementarTentativasLogin(int id) {
        repository.findById(id).ifPresent(usuario -> {
            usuario.setTentativasLogin(usuario.getTentativasLogin() + 1);
            if (usuario.getTentativasLogin() >= 3) {
                usuario.setBloqueado(true);
            }
            repository.save(usuario);
        });
    }

    public void verificarSenhaExpirada(int id) {
        repository.findById(id).ifPresent(usuario -> {
            if (usuario.getUltimoLogin() != null && 
                usuario.getUltimoLogin().isBefore(LocalDate.now().minusDays(30))) {
                    
                usuario.setSenhaExpirada(true);
                repository.save(usuario);
            }
        });
    }
}
