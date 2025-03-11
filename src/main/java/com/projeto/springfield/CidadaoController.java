package com.projeto.springfield;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cidadaos")
public class CidadaoController {

    @Autowired
    private CidadaoService cidadaoService;

    @GetMapping
    public List<Cidadao> listarTodos() {
        return cidadaoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cidadao> buscarPorId(@PathVariable int id) {
        return cidadaoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Cidadao cadastrar(@RequestBody Cidadao cidadao) {
        return cidadaoService.cadastrar(cidadao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cidadao> atualizar(@PathVariable int id, @RequestBody Cidadao cidadao) {
        if (!cidadaoService.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        cidadao.setId(id);
        return ResponseEntity.ok(cidadaoService.atualizar(cidadao));
    }
}