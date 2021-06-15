package com.accenture.academico.sistemabanco.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "TB_PESSOA")
@Getter
@Setter
@AllArgsConstructor
@SuperBuilder
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PESSOA")
	private Integer idPessoa;

	@CPF(message = "Cpf deve ser válido!")
	@Column(name = "CPF_PESSOA")
	@Size(min = 13, max = 13)
	private String cpf;

	@NotBlank(message = "Nome não pode ser nulo e nem vazio!")
	@Min(value = 3, message = "Nome deve ter ao menos três caracteres!")
	@Max(value = 161, message = "Nome deve ter no máximo 161 caracteres!")
	@Column(name = "NOME_PESSOA")
	private String nome;

	@NotBlank(message = "Telefone não pode ser nulo e nem vazio!")
	@Size(min = 12, max = 12, message = "Telefone deve possuir 12 caracteres DDDXXXXXXXXX!")
	@Column(name = "TEL_PESSOA")
	private Long telefone;
	
	@OneToOne
	@JoinColumn(name = "ID_CONTA")
	@MapsId
	@JsonIgnore
	private Conta conta;

}
