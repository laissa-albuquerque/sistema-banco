package com.accenture.academico.sistemabanco.controller.mapper;

import com.accenture.academico.sistemabanco.controller.dto.AlterarAgenciaDto;
import com.accenture.academico.sistemabanco.controller.dto.InserirAgenciaDto;
import com.accenture.academico.sistemabanco.model.Agencia;

public class AgenciaMapper {
	
	public static Agencia toAgencia(InserirAgenciaDto dto) {
		return Agencia.builder()
				.nomeAgencia(dto.getNomeAgencia())
				.endereco(dto.getEndereco())
				.numeroAgencia(dto.getNumeroAgencia())
				.telefone(dto.getTelefone())
				.build();
	}
	
	public static Agencia toAgencia(AlterarAgenciaDto dto) {
		return Agencia.builder()
				.idAgencia(dto.getIdAgencia())
				.nomeAgencia(dto.getNomeAgencia())
				.endereco(dto.getEndereco())
				.numeroAgencia(dto.getNumeroAgencia())
				.telefone(dto.getTelefone())
				.build();
	}

}
