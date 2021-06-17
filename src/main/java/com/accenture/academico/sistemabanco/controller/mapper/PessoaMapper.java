package com.accenture.academico.sistemabanco.controller.mapper;

import com.accenture.academico.sistemabanco.controller.dto.AlterarNomeETelefonePessoaDto;
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
	
	public static Pessoa toPessoa(AlterarNomeETelefonePessoaDto dto) {
		return Pessoa.builder()
				.nome(dto.getNome())
				.telefone(dto.getTelefone())
				.build();
	}
	
}
