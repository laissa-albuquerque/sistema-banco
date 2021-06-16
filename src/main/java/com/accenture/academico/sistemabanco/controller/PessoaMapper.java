package com.accenture.academico.sistemabanco.controller;

import com.accenture.academico.sistemabanco.controller.dto.InserirPessoaDto;
import com.accenture.academico.sistemabanco.model.Pessoa;

public class PessoaMapper {
	
	public static Pessoa toPessoa(InserirPessoaDto dto) {
		return Pessoa.builder()
				.cpf(dto.getCpf())
				.nome(dto.getNome())
				.telefone(dto.getTelefone())
				.build();
		}
}
