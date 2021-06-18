package com.accenture.academico.sistemabanco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.accenture.academico.sistemabanco.model.Agencia;
import com.accenture.academico.sistemabanco.model.Conta;
import com.accenture.academico.sistemabanco.repository.ContaRepository;
import com.accenture.academico.sistemabanco.service.exception.EntityNotFoundException;
import com.accenture.academico.sistemabanco.service.exception.NegocioException;

import lombok.SneakyThrows;

@Service
public class ContaService {

	@Autowired
	private ContaRepository contaRepository;

	@Autowired
	private AgenciaService agenciaService;

	@SneakyThrows
	public Conta cadastrarConta(Conta conta, Integer idConta) {
		Agencia agencia = agenciaService.buscarAgenciaPorId(idConta);

		conta.setAgencia(agencia);
		conta.setSaldo(0.0);

		Conta contaPersistida = contaRepository.save(conta);
		
		if (contaPersistida == null) {
			throw new NegocioException("Erro ao salvar conta");
		}
		
		return contaPersistida;
	}

	public List<Conta> buscarTodasAsContas() {
		return contaRepository.findAll();
	}

	@SneakyThrows
	public Conta buscarContaPorId(Integer id) {
		return contaRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Id de Conta não encontrado"));
	}
	
	@SneakyThrows
	public Conta buscarContaPorNumero(Integer numConta) {
		return contaRepository.findByNumeroConta(numConta)
				.orElseThrow(() -> new EntityNotFoundException("Conta não encontrada"));
	}

	@SneakyThrows
	public void removerContaPorId(Integer id) {
		try {
			contaRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntityNotFoundException("É necessário informar um ID válido para exclusão da conta");
		}
		
	}

	@SneakyThrows
	public void realizarDeposito(Integer idConta, Double valor) {
		Conta conta = buscarContaPorId(idConta);
		
		if (valor <= 0) {
			throw new NegocioException("O valor de depósito não pode ser negativo");
		}

		conta.setSaldo(conta.getSaldo() + valor);

		contaRepository.save(conta);		
	}
	
	@SneakyThrows
	public void realizarSaque(Integer idConta, Double valor) {
		Conta conta = buscarContaPorId(idConta);
		
		if (valor < conta.getSaldo()) {
			throw new NegocioException("Saldo insuficiente");
		}
		conta.setSaldo(conta.getSaldo() - valor);
		
		contaRepository.save(conta);
	}
	
	@SneakyThrows
	public void realizarTransferencia(Conta contaOrigem, Conta contaDestino, Double valor) {
		
		if (valor < contaOrigem.getSaldo()) {
			throw new NegocioException("Saldo insuficiente");
		}
		
		contaOrigem.setSaldo(contaOrigem.getSaldo() - valor);
		contaDestino.setSaldo(contaDestino.getSaldo() + valor);
		
		contaRepository.save(contaOrigem);
		contaRepository.save(contaDestino);
	}

}
