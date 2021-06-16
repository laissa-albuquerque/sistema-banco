package com.accenture.academico.sistemabanco.controller.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@SuperBuilder
public class InserirContaDto {
	
	@NotNull(message = "Numero da conta não pode ser nula e nem vazia!")
	@Max(value = 99999999, message = "Número da conta deve possuir {value} caracteres!")
	@Min(value = 10000000, message = "Número da conta deve possuir {value} caracteres!")
	private Integer numeroConta;
	
	@NotNull(message = "Numero do digíto não pode ser nulo e nem vazio!")
	@Max(value = 9, message = "Número do dígito deve possuir {value} caractere!")
	@Min(value = 1, message = "Número do dígito deve possuir {value} caractere!")
	private Integer digitoVerificador;
	
	private Integer idAgencia;

}
