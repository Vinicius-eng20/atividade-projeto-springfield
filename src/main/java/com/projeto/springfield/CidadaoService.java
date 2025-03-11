package com.projeto.springfield;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CidadaoService {

    @Autowired
    private CidadaoRepository cidadaoRepository;

    public List<Cidadao> listarTodos() {
        return cidadaoRepository.findAll();
    }

    public Optional<Cidadao> buscarPorId(int id) {
        return cidadaoRepository.findById(id);
    }

    public Cidadao cadastrar(Cidadao cidadao) {
        return cidadaoRepository.save(cidadao);
    }

    public Cidadao atualizar(Cidadao cidadao) {
        return cidadaoRepository.save(cidadao);
    }
}
