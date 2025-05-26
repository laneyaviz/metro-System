package com.exemplo.metrosystem.model;

import jakarta.persistence.*;

@Entity
public class Estacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String linha;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getLinha() { return linha; }
    public void setLinha(String linha) { this.linha = linha; }
}