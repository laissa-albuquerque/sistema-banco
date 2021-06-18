package com.accenture.academico.sistemabanco.controller.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class InserirAgenciaDto {

	@NotNull(message = "Agencia não pode ser nula!")
	@Min(value = 1000, message = "Agência deve ter ao menos {value} digitos!")
	@Max(value = 9999, message = "Agência deve ter no máximo {value} digitos!")
	private Integer numeroAgencia;

	@NotBlank(message = "Nome não pode ser nulo e nem vazio!")
	@Size(min = 3, max = 161, message = "Nome deve ter no mínimo {min} e no máximo {max} caracteres!")
	private String nomeAgencia;

	@NotBlank(message = "Endereço não pode ser nulo e nem vazio!")
	@Size(max = 161, message = "Endereço deve ter no máximo {max} caracteres!")
	private String endereco;

	@NotBlank(message = "Telefone não pode ser nulo!")
	@Size(min = 11, max = 11, message = "Telefone deve possuir {min} caracteres DDDXXXXXXXXX!")
	private String telefone;

}
