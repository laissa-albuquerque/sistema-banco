package com.accenture.academico.sistemabanco;

import com.accenture.academico.sistemabanco.model.Transacao;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;

import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)

public class TransacaoServiceTest {

	@Rule
	@Deprecated
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void cadastrarTransacaotest() {
		Transacao transacao = new Transacao();
		transacao.setIdTransacao(9);

		transacao.setValor(450.56);
		transacao.setTipoOperacao(1);

		Assertions.assertThat(transacao.getValor()).isNotNull();

	}

}
