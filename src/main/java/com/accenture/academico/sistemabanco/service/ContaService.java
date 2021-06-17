package com.accenture.academico.sistemabanco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.academico.sistemabanco.model.Agencia;
import com.accenture.academico.sistemabanco.model.Conta;
import com.accenture.academico.sistemabanco.repository.ContaRepository;

@Service
public class ContaService {

	@Autowired
	private ContaRepository contaRepository;

	@Autowired
	private AgenciaService agenciaService;

	public Conta cadastrarConta(Conta conta, Integer idConta) {

		Agencia agencia = agenciaService.buscarAgenciaPorId(idConta);

		conta.setAgencia(agencia);
		conta.setSaldo(0.0);

		return contaRepository.save(conta);
	}

	public List<Conta> buscarTodasAsContas() {
		return contaRepository.findAll();
	}

	public Conta buscarContaPorId(Integer id) {
		return contaRepository.findById(id).get();
	}
	
	public Conta buscarContaPorNumero(Integer numConta) {
		return contaRepository.findByNumeroConta(numConta).get();
	}

	public void removerContaPorId(Integer id) {
		contaRepository.deleteById(id);
	}

	public void realizarDeposito(Integer idConta, Double valor) {
		Conta conta = buscarContaPorId(idConta);

		conta.setSaldo(conta.getSaldo() + valor);

		contaRepository.save(conta);
	}
	
	public void realizarSaque(Integer idConta, Double valor) {
		Conta conta = buscarContaPorId(idConta);
		conta.setSaldo(conta.getSaldo() - valor);
		
		contaRepository.save(conta);
	}
	
	public void realizarTransferencia(Conta contaOrigem, Conta contaDestino, Double valor) {
		
		contaOrigem.setSaldo(contaOrigem.getSaldo() - valor);
		contaDestino.setSaldo(contaDestino.getSaldo() + valor);
		
		contaRepository.save(contaOrigem);
		contaRepository.save(contaDestino);
	}

}
