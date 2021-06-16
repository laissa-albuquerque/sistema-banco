package com.accenture.academico.sistemabanco.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accenture.academico.sistemabanco.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
	Optional<Pessoa> findByNome(String nome); // achar nome
	Pessoa findByCpf(String cpf); // achar cpf

}
