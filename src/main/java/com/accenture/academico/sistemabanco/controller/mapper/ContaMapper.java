package com.accenture.academico.sistemabanco.controller.mapper;

import com.accenture.academico.sistemabanco.controller.dto.InserirContaDto;
import com.accenture.academico.sistemabanco.model.Conta;

public class ContaMapper {
	
	public static Conta toConta (InserirContaDto dto) {
		return Conta.builder()
				.numeroConta(dto.getNumeroConta())
				.digitoVerificador(dto.getDigitoVerificador())
				.build();
	}
}
