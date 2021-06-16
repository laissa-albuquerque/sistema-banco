package com.accenture.academico.sistemabanco.controller.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@SuperBuilder
public class InserirPessoaDto {
	
	@CPF(message = "Cpf deve ser válido!")
	private String cpf;

	@NotBlank(message = "Nome não pode ser nulo e nem vazio!")
	@Size(min = 3, max = 161, message = "Nome deve conter no máximo {max} caracteres!")
	private String nome;

	@NotBlank(message = "Telefone não pode ser nulo e nem vazio!")
	@Size(min = 12, max = 12, message = "Telefone deve possuir {max} caracteres DDDXXXXXXXXX!")
	private String telefone;
	


}
