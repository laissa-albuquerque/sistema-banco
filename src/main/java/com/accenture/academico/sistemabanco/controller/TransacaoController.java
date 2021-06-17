package com.accenture.academico.sistemabanco.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.accenture.academico.sistemabanco.controller.dto.InserirTransacaoDto;
import com.accenture.academico.sistemabanco.controller.dto.InserirTransferenciaDto;
import com.accenture.academico.sistemabanco.controller.mapper.TransacaoMapper;
import com.accenture.academico.sistemabanco.model.Transacao;
import com.accenture.academico.sistemabanco.service.TransacaoService;

@Controller
@RequestMapping("/transacao")
public class TransacaoController {
	
	@Autowired
	private TransacaoService transacaoService;
	
	@PostMapping("/inserir-transacao")
	public ResponseEntity<Transacao> cadastrarTransacao(@Valid @RequestBody InserirTransacaoDto transacaoDto) {
		Transacao transacaoCadastrada = transacaoService.cadastrarTransacao(TransacaoMapper.toTransacao(transacaoDto), transacaoDto.getIdConta());
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(transacaoCadastrada.getIdTransacao()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PostMapping("/inserir-transferencia")
	public ResponseEntity<Void> cadastrarTranferencia(@Valid @RequestBody InserirTransferenciaDto transferenciaDto) {
		transacaoService.cadastrarTransferencia(transferenciaDto.getNumContaOrigem(), transferenciaDto.getNumContaDestino(), TransacaoMapper.toTransacao(transferenciaDto.getTransacaoOrigem()), TransacaoMapper.toTransacao(transferenciaDto.getTransacaoDestino()));
				
		return ResponseEntity.ok().build();
	}
	
	
	

}
