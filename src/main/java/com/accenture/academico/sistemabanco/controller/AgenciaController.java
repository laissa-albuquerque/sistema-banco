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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.accenture.academico.sistemabanco.controller.dto.AlterarAgenciaDto;
import com.accenture.academico.sistemabanco.controller.dto.InserirAgenciaDto;
import com.accenture.academico.sistemabanco.model.Agencia;
import com.accenture.academico.sistemabanco.service.AgenciaService;

@Controller
@RequestMapping("/agencia")
public class AgenciaController {
	
	@Autowired
	private AgenciaService service;
	
	@PostMapping
	public ResponseEntity<Agencia> cadastrarAgencia(@Valid @RequestBody InserirAgenciaDto agenciaDto) {
		Agencia agenciaCadastrada = service.cadastrarAgencia(AgenciaMapper.toAgencia(agenciaDto));
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(agenciaCadastrada.getIdAgencia()).toUri();
		
		return ResponseEntity.created(uri).build();		
	}
	
	@GetMapping
	public ResponseEntity<List<Agencia>> buscarTodasAsAgencias() {
		List<Agencia> listaAgencias = service.buscarTodasAsAgencias();
		
		return ResponseEntity.ok().body(listaAgencias);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Agencia> buscarAgenciaPorId(@PathVariable Integer id) {
		
		Agencia agencia = service.buscarAgenciaPorId(id);
		return ResponseEntity.ok().body(agencia);
	}
	
	@PutMapping
	public ResponseEntity<Agencia> atualizarAgencia(@Valid @RequestBody AlterarAgenciaDto agenciaDto) {
		Agencia agenciaAtualizada = service.atualizarAgencia(AgenciaMapper.toAgencia(agenciaDto));
		return ResponseEntity.ok().body(agenciaAtualizada);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> removerAgenciaPorId(@PathVariable Integer id) {
		service.removerAgenciaPorId(id);
		return ResponseEntity.noContent().build();
	}

}
