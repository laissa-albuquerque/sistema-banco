package com.accenture.academico.sistemabanco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.academico.sistemabanco.model.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Integer>{

}
