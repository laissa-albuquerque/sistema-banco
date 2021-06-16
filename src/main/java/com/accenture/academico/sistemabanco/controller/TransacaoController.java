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
import com.accenture.academico.sistemabanco.model.Transacao;
import com.accenture.academico.sistemabanco.service.TransacaoService;

@Controller
@RequestMapping("/transacao")
public class TransacaoController {
	
	@Autowired
	private TransacaoService transacaoService;
	
	@PostMapping
	public ResponseEntity<Transacao> cadastrarTransacao(@Valid @RequestBody InserirTransacaoDto transacaoDto) {
		Transacao transacaoCadastrada = transacaoService.cadastrarTransacao(TransacaoMapper.toTransacao(transacaoDto), transacaoDto.getIdConta());
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(transacaoCadastrada.getIdTransacao()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	

}
