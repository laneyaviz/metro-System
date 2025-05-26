package com.exemplo.metrosystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.exemplo.metrosystem.model.Estacao;
import com.exemplo.metrosystem.service.EstacaoService;

import java.util.List;

@RestController
@RequestMapping("/api/estacoes")
@CrossOrigin
public class EstacaoController {

    @Autowired
    private EstacaoService service;

    @GetMapping
    public List<Estacao> listar() {
        return service.listar();
    }

    @PostMapping
    public Estacao salvar(@RequestBody Estacao estacao) {
        return service.salvar(estacao);
    }
}