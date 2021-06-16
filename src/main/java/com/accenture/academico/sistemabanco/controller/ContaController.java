package com.accenture.academico.sistemabanco.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.accenture.academico.sistemabanco.controller.dto.InserirContaDto;
import com.accenture.academico.sistemabanco.model.Conta;
import com.accenture.academico.sistemabanco.service.ContaService;

@Controller
@RequestMapping("/conta")
public class ContaController {
	
	@Autowired
	private ContaService contaService;	
	
	@PostMapping
	public ResponseEntity<Conta> cadastrarConta(@Valid @RequestBody InserirContaDto contaDto) {
		Conta contaCadastrada = contaService.cadastrarConta(ContaMapper.toConta(contaDto), contaDto.getIdAgencia());
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(contaCadastrada.getIdConta()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping
	public ResponseEntity<List<Conta>> buscarTodasAsContas() {
		List<Conta> listaContas = contaService.buscarTodasAsContas();
		
		return ResponseEntity.ok().body(listaContas);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Conta> buscarContaPorId(@PathVariable Integer id) {
		Conta conta = contaService.buscarContaPorId(id);
		
		return ResponseEntity.ok().body(conta);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> removerContaPorId(@PathVariable Integer id) {
		contaService.removerContaPorId(id);
		
		return ResponseEntity.noContent().build();
	}

}