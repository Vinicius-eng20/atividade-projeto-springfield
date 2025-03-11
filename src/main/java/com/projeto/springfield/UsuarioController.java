package com.projeto.springfield;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarUsuario(@RequestBody Usuario usuario) {
        try {
            usuarioService.cadastrarUsuario(usuario);
            return ResponseEntity.ok("Usuário cadastrado com sucesso.");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String senha) {
        Optional<Usuario> usuarioOpt = usuarioService.buscarPorUsername(username);
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            if (usuario.isBloqueado()) {
                return ResponseEntity.badRequest().body("Usuário bloqueado.");
            }
            if (usuario.getSenha().equals(senha)) {
                usuarioService.registrarLogin(usuario.getId());
                return ResponseEntity.ok("Login realizado com sucesso.");
            } else {
                usuarioService.incrementarTentativasLogin(usuario.getId());
                return ResponseEntity.badRequest().body("Senha incorreta.");
            }
        } else {
            return ResponseEntity.badRequest().body("Usuário não encontrado.");
        }
    }

    @PostMapping("/trocar-senha")
    public ResponseEntity<String> trocarSenha(@RequestParam int id, @RequestParam String novaSenha) {
        usuarioService.atualizarSenha(id, novaSenha);
        return ResponseEntity.ok("Senha atualizada com sucesso.");
    }

    @PostMapping("/bloquear")
    public ResponseEntity<String> bloquearUsuario(@RequestParam int id) {
        usuarioService.bloquearUsuario(id);
        return ResponseEntity.ok("Usuário bloqueado com sucesso.");
    }

    @PostMapping("/desbloquear")
    public ResponseEntity<String> desbloquearUsuario(@RequestParam int id) {
        usuarioService.desbloquearUsuario(id);
        return ResponseEntity.ok("Usuário desbloqueado com sucesso.");
    }

}
