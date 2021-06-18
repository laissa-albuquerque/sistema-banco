package com.accenture.academico.sistemabanco;

import com.accenture.academico.sistemabanco.model.Conta;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;

import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)

public class ContaServiceTest {

	@Rule
	@Deprecated
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void cadastrarContatest() {
		Conta conta = new Conta();
		conta.setIdConta(9);
		conta.setNumeroConta(78456);
		conta.setDigitoVerificador(46);

		conta.setSaldo(452.17);
		// this.contaService.cadastrarConta(conta, 9);
		Assertions.assertThat(conta.getIdConta()).isNotNull();
		Assertions.assertThat(conta.getNumeroConta()).isEqualTo(78456);
		Assertions.assertThat(conta.getDigitoVerificador()).isEqualTo(46);
		Assertions.assertThat(conta.getSaldo()).isEqualTo(452.17);

	}

}
