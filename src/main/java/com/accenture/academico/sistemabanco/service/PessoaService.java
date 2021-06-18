package com.accenture.academico.sistemabanco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.accenture.academico.sistemabanco.model.Conta;
import com.accenture.academico.sistemabanco.model.Pessoa;
import com.accenture.academico.sistemabanco.repository.PessoaRepository;
import com.accenture.academico.sistemabanco.service.exception.EntityNotFoundException;
import com.accenture.academico.sistemabanco.service.exception.NegocioException;

import lombok.SneakyThrows;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private ContaService contaService;
	
	@SneakyThrows
	public Pessoa cadastrarPessoa(Pessoa pessoa, Integer idConta) { 
		Conta conta = contaService.buscarContaPorId(idConta);
		
		pessoa.setConta(conta);
		
		Pessoa pessoaPersistida = pessoaRepository.save(pessoa);
		
		if (pessoaPersistida == null) {
			throw new NegocioException("Erro ao cadastrar cliente");
		}
		
		return pessoaPersistida;
	}
	
	public List<Pessoa> listarTodasAsPessoas() {
		return pessoaRepository.findAll(); 
	}
	
	@SneakyThrows
	public Pessoa buscarPessoaPorId(Integer id) {
		return pessoaRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Id de Conta não encontrado"));
	}
	
	@SneakyThrows
	public Pessoa alterarNomeETelefone(Pessoa pessoa, Integer id) {
		Pessoa pessoaAtualizada = buscarPessoaPorId(id);
		
		pessoaAtualizada.setNome(pessoa.getNome());
		pessoaAtualizada.setTelefone(pessoa.getTelefone());
		
		Pessoa atualizadaPessoa = pessoaRepository.save(pessoaAtualizada);
		
		if (atualizadaPessoa == null) {
			throw new NegocioException("Erro ao atualizar dados");
		}
		return atualizadaPessoa;
	}
	
	@SneakyThrows
	public void removerPessoaPorId(Integer id) {
		try {
		pessoaRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntityNotFoundException("É necessário informar um ID válido para exclusão do Cliente");
		}		
	}
}
