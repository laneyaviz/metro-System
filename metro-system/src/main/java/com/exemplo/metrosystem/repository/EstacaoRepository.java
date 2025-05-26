package com.exemplo.metrosystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.exemplo.metrosystem.model.Estacao;

public interface EstacaoRepository extends JpaRepository<Estacao, Long> {
}