package com.exemplo.metrosystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exemplo.metrosystem.repository.EstacaoRepository;
import com.exemplo.metrosystem.model.Estacao;

import java.util.List;

@Service
public class EstacaoService {

    @Autowired
    private EstacaoRepository repository;

    public List<Estacao> listar() {
        return repository.findAll();
    }

    public Estacao salvar(Estacao estacao) {
        return repository.save(estacao);
    }
}