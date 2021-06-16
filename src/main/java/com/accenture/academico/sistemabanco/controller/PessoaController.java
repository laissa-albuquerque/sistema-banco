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

import com.accenture.academico.sistemabanco.controller.dto.AlterarNomeETelefonePessoaDto;
import com.accenture.academico.sistemabanco.controller.dto.InserirPessoaDto;
import com.accenture.academico.sistemabanco.model.Pessoa;
import com.accenture.academico.sistemabanco.service.PessoaService;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	PessoaService pessoaService;
	
	@PostMapping
	public ResponseEntity<Pessoa> cadastrarPessoa(@Valid @RequestBody InserirPessoaDto pessoaDto) {
		Pessoa pessoaCadastrada = pessoaService.cadastrarPessoa(PessoaMapper.toPessoa(pessoaDto), pessoaDto.getIdConta());
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(pessoaCadastrada.getIdPessoa()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping
	public ResponseEntity<List<Pessoa>> buscarTodasAsPessoas() {
		List<Pessoa> listaPessoas = pessoaService.listarTodasAsPessoas();
		
		return ResponseEntity.ok().body(listaPessoas);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> buscarPessoaPorId(@PathVariable Integer id) {
		Pessoa pessoa = pessoaService.buscarPessoaPorId(id);
		
		return ResponseEntity.ok().body(pessoa);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Pessoa> atualizarNomeETelefonePessoa(@Valid @RequestBody AlterarNomeETelefonePessoaDto pessoaDto, @PathVariable Integer id) {
		Pessoa pessoaAtualizada = pessoaService.alterarNomeETelefone(PessoaMapper.toPessoa(pessoaDto), id);
		
		return ResponseEntity.ok().body(pessoaAtualizada);
	}

	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> removerPessoaPorId(@PathVariable Integer id) {
		pessoaService.removerPessoaPorId(id);
		
		return ResponseEntity.noContent().build();
	}

}



