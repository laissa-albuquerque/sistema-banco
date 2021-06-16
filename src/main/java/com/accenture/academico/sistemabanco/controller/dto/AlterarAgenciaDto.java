package com.accenture.academico.sistemabanco.controller.dto;

import javax.persistence.Column;
import javax.persistence.Id;
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
public class AlterarAgenciaDto {
	
	@Id 
	@Column(name = "ID_AGENCIA")
	private Integer idAgencia;
	
	@NotNull(message = "Agencia não pode ser nula!")
	@Min(value = 1000, message = "Agência deve ter ao menos {value} digitos!")
	@Max(value = 9999, message = "Agência deve ter no máximo {value} digitos!")
	@Column(name = "NUMERO_AGENCIA")
	private Integer numeroAgencia;
	
	@NotBlank(message = "Nome não pode ser nulo e nem vazio!")
	@Size(min = 3 ,max = 161, message = "Nome deve ter no mínimo {min} e no máximo {max} caracteres!")
	@Column(name = "NOME_AGENCIA")
	private String nomeAgencia;
	
	@NotBlank(message = "Endereço não pode ser nulo e nem vazio!")
	@Size(max = 161, message = "Endereço deve ter no máximo {max} caracteres!")
	@Column(name = "END_AGENCIA")
	private String endereco;
	
	@NotBlank(message = "Telefone não pode ser nulo!")
	@Size(min = 12, max = 12, message = "Telefone deve possuir {min} caracteres DDDXXXXXXXXX!")
	@Column(name = "TEL_AGENCIA")
	private String telefone;
	
	

}
