package com.accenture.academico.sistemabanco.controller.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@AllArgsConstructor
@SuperBuilder
public class InserirTransferenciaDto {
	
	@NotNull
	private Integer numContaOrigem; 
	
	@NotNull
	private Integer numContaDestino;
	
	private InserirTransacaoDto transacaoOrigem;
	
	private InserirTransacaoDto transacaoDestino;

}
