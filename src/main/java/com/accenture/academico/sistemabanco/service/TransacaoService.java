package com.accenture.academico.sistemabanco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.academico.sistemabanco.model.Conta;
import com.accenture.academico.sistemabanco.model.Transacao;
import com.accenture.academico.sistemabanco.model.enums.TipoOperacaoEnum;
import com.accenture.academico.sistemabanco.repository.TransacaoRepository;

@Service
public class TransacaoService {
	
	@Autowired
	private TransacaoRepository transacaoRepository;
	
	@Autowired
	private ContaService contaService;
	
	public Transacao cadastrarTransacao(Transacao transacao, Integer idConta) {
		
		Conta conta = contaService.buscarContaPorId(idConta);
		
		transacao.setConta(conta);
		
		if (TipoOperacaoEnum.toEnum(transacao.getTipoOperacao()) == TipoOperacaoEnum.DEPOSITO) {
			contaService.realizarDeposito(conta.getIdConta(), transacao.getValor());
			
		} else if (TipoOperacaoEnum.toEnum(transacao.getTipoOperacao()) == TipoOperacaoEnum.SAQUE) {
			
		} else if (TipoOperacaoEnum.toEnum(transacao.getTipoOperacao()) == TipoOperacaoEnum.TRANSFERENCIA) {
			
		}
		
		
		return transacaoRepository.save(transacao);
	}

}
