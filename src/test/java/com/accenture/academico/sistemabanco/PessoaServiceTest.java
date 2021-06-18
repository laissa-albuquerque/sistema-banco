package com.accenture.academico.sistemabanco;

import com.accenture.academico.sistemabanco.model.Pessoa;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;


import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)

public class PessoaServiceTest {
   

    @Rule
    @Deprecated
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void cadastrarPessoatest() {

        Pessoa pessoa = new Pessoa();
        pessoa.setIdPessoa(78);
        pessoa.setCpf("4785799963");
        pessoa.setNome("William");
        pessoa.setTelefone("083458712963");

        Assertions.assertThat(pessoa.getIdPessoa()).isNotNull();
        Assertions.assertThat(pessoa.getCpf()).isEqualTo("4785799963");
        Assertions.assertThat(pessoa.getNome()).isEqualTo("William");
        Assertions.assertThat(pessoa.getTelefone()).isEqualTo("083458712963");

    }

}
