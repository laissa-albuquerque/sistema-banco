package com.accenture.academico.sistemabanco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.academico.sistemabanco.model.Conta;
import com.accenture.academico.sistemabanco.model.Pessoa;
import com.accenture.academico.sistemabanco.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private ContaService contaService;
	
	public Pessoa cadastrarPessoa(Pessoa pessoa, Integer idConta) { // salva no repositorio
		Conta conta = contaService.buscarContaPorId(idConta);
		
		pessoa.setConta(conta);
		
		return pessoaRepository.save(pessoa);
	}
	
	public List<Pessoa> listarTodasAsPessoas() {
		return pessoaRepository.findAll(); // armazena em lista as pessoas cadastradas 
	}
	
	public Pessoa buscarPessoaPorId(Integer id) {
		return pessoaRepository.findById(id).get();
	}
	
	public Pessoa alterarNomeETelefone(Pessoa pessoa, Integer id) {
		Pessoa pessoaAtualizada = buscarPessoaPorId(id);
		
		pessoaAtualizada.setNome(pessoa.getNome());
		pessoaAtualizada.setTelefone(pessoa.getTelefone());
		
		return pessoaRepository.save(pessoaAtualizada);
	}
	
	public void removerPessoaPorId(Integer id) {
		pessoaRepository.deleteById(id);
	}
}
