package com.accenture.academico.sistemabanco.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "TB_CONTA")
@Getter
@Setter
@AllArgsConstructor
@SuperBuilder
public class Conta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CONTA")
	private Integer idConta;
	
	@NotBlank(message = "Numero da conta não pode ser nula e nem vazia!")
	@Size(min = 8, max = 8, message = "Número da conta deve possuir 8 caracteres!")
	@Column(name = "NUMERO_CONTA")
	private Integer numeroConta;
	
	@NotBlank(message = "Numero do digíto não pode ser nulo e nem vazio!")
	@Size(min = 1, max = 1, message = "Número do dígito deve possuir 1 caractere!")
	@Column(name = "DIGITO_VERIFICADOR")
	private Integer digitoVerificador;
	
	@NotBlank(message = "Saldo não pode ser nulo e nem vazio!")
	@Column(name = "SALDO_CONTA")
	private Double saldo;
	
	@NotBlank(message = "Saldo não pode ser nulo e nem vazio!")
	@Column(name = "COFRINHO_CONTA")
	private Double cofrinho;
	
	@OneToMany(mappedBy = "conta")
	private List<Transacao> transacoes;
	
	@ManyToOne
	@JoinColumn(name = "ID_AGENCIA", nullable = false)	
	private Agencia agencia;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "conta")
	private Pessoa pessoa;

}
