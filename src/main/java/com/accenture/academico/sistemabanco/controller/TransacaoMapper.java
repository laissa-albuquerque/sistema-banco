package com.accenture.academico.sistemabanco.controller;

import com.accenture.academico.sistemabanco.controller.dto.InserirTransacaoDto;
import com.accenture.academico.sistemabanco.model.Transacao;

public class TransacaoMapper {

	public static Transacao toTransacao(InserirTransacaoDto dto) {
		return Transacao.builder()
				.dataHoraMovimentacao(dto.getDataHoraMovimentacao())
				.tipoOperacao(dto.getTipoOperacao().getCodigo())
				.valor(dto.getValor())
				.build();
	}
}
