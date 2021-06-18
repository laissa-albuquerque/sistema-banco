package com.accenture.academico.sistemabanco;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.accenture.academico.sistemabanco.model.Agencia;
import com.accenture.academico.sistemabanco.service.AgenciaService;

@SpringBootTest
@RunWith(SpringRunner.class)
// @DataJpaTest
public class AgenciaServiceTest {
	@Autowired
	private AgenciaService agenciaService;
	@Rule
	@Deprecated
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void CadastrarAgenciatest() {
		Agencia agencia = new Agencia();
		agencia.setIdAgencia(5);
		agencia.setNumeroAgencia(1002);
		agencia.setNomeAgencia("lua_agencia");
		agencia.setEndereco("Rua teste dos testes");
		agencia.setTelefone("083784512639");
		this.agenciaService.cadastrarAgencia(agencia);
		Assertions.assertThat(agencia.getIdAgencia()).isNotNull();
		Assertions.assertThat(agencia.getIdAgencia()).isEqualTo(5);
		Assertions.assertThat(agencia.getEndereco()).isEqualTo("Rua teste dos testes");
		Assertions.assertThat(agencia.getNomeAgencia()).isEqualTo("lua_agencia");
		Assertions.assertThat(agencia.getTelefone()).isNotNull();

	}

}
