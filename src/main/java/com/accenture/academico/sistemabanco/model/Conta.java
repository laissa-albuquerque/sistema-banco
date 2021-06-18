package com.accenture.academico.sistemabanco.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "TB_CONTA")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Conta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CONTA")
	private Integer idConta;
	
	@NotNull(message = "Numero da conta não pode ser nula e nem vazia!")
	@Max(value = 99999999, message = "Número da conta deve possuir {value} caracteres!")
	@Min(value = 10000000, message = "Número da conta deve possuir {value} caracteres!")
	@Column(name = "NUMERO_CONTA")
	private Integer numeroConta;
	
	@NotNull(message = "Numero do digíto não pode ser nulo e nem vazio!")
	@Max(value = 9, message = "Número do dígito deve possuir {value} caractere!")
	@Min(value = 1, message = "Número do dígito deve possuir {value} caractere!")
	@Column(name = "DIGITO_VERIFICADOR")
	private Integer digitoVerificador;
	
	@NotNull(message = "Saldo não pode ser nulo e nem vazio!")
	@Column(name = "SALDO_CONTA")
	private Double saldo;
	
	@OneToMany(mappedBy = "conta")
	private List<Transacao> transacoes;
	
	@ManyToOne
	@JoinColumn(name = "ID_AGENCIA", nullable = false)	
	private Agencia agencia;

}
