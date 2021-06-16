package com.accenture.academico.sistemabanco.controller.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.accenture.academico.sistemabanco.model.enums.TipoOperacaoEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@SuperBuilder
public class InserirTransacaoDto {
	
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime dataHoraMovimentacao;
	
	private TipoOperacaoEnum tipoOperacao;
	
	@NotNull(message = "Valor não pode ser nulo!")
	private Double valor;

	private Integer idConta;

}
