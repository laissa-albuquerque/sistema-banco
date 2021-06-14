package com.accenture.academico.sistemabanco.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "TB_AGENCIA")
@Getter
@Setter
@AllArgsConstructor
@SuperBuilder
public class Agencia {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_AGENCIA")
	private Integer idAgencia;
	
	@NotBlank(message = "Nome não pode ser nulo e nem vazio!")
	@Size(min = 4, max = 4)
	@Column(name = "NUMERO_AGENCIA")
	private Integer numeroAgencia;
	
	@NotBlank(message = "Nome não pode ser nulo e nem vazio!")
	@Min(value = 3, message = "Nome deve ter ao menos três caracteres!")
	@Max(value = 161, message = "Nome deve ter no máximo 161 caracteres!")
	@Column(name = "NOME_AGENCIA")
	private String nome;
	
	@NotBlank(message = "Endereço não pode ser nulo e nem vazio!")
	@Max(value = 161, message = "Endereço deve ter no máximo 161 caracteres!")
	@Column(name = "END_AGENCIA")
	private String endereco;
	
	@NotBlank(message = "Telefone não pode ser nulo e nem vazio!")
	@Size(min = 12, max = 12, message = "Telefone deve possuir 12 caracteres DDDXXXXXXXXX!")
	@Column(name = "TEL_AGENCIA")
	private Long telefone;
	
	@OneToMany(mappedBy = "agencia")
	private List<Conta> contas;
}
