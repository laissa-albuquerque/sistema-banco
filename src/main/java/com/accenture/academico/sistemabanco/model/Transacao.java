package com.accenture.academico.sistemabanco.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "TB_TRANSACAO")
@Getter
@Setter
@AllArgsConstructor
@SuperBuilder
public class Transacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TRANSACAO")
	private Integer idTransacao;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime dataHoraMovimentacao;
	
	private Integer tipoOperacao;
	
	@NotNull(message = "Valor não pode ser nulo!")
	private Double valor;

	@ManyToOne
	@JoinColumn(name = "ID_CONTA", nullable = false)
	private Conta conta;
	

}
