package com.accenture.academico.sistemabanco.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.academico.sistemabanco.model.Conta;

public interface ContaRepository extends JpaRepository<Conta, Integer> {
	Optional<Conta> findByNumeroConta(Integer numeroConta);

}
