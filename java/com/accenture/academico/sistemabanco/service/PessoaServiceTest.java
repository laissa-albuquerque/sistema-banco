package com.accenture.academico.sistemabanco.service;

import com.accenture.academico.sistemabanco.model.Pessoa;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)

public class PessoaServiceTest {
    @Autowired
    private PessoaService pessoaService;
    @Rule
    @Deprecated
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void cadastrarPessoatest() {
        Pessoa pessoa = new Pessoa(5, "14785799963", "William", "083458712963", null);
        this.pessoaService.cadastrarPessoa(pessoa, pessoa.getIdPessoa());
        Assertions.assertThat(pessoa.getIdPessoa()).isNotNull();
        Assertions.assertThat(pessoa.getCpf()).isEqualTo("4785799963");
        Assertions.assertThat(pessoa.getNome()).isEqualTo("William");
        Assertions.assertThat(pessoa.getTelefone()).isEqualTo("083458712963");
        Assertions.assertThat(pessoa.getConta()).isNull();
    }

    @Test
    public void buscarPessoaPorIdtest() {
        Pessoa pessoa = new Pessoa(5, "14785799963", "William", "083458712963", null);
        pessoa.setIdPessoa(5);
        this.pessoaService.buscarPessoaPorId(5);
        Assertions.assertThat(pessoaService.buscarPessoaPorId(pessoa.getIdPessoa())).isEqualTo(5);

    }

    @Test
    public void alterarNomeETelefoneTest() {
        Pessoa pessoa2 = new Pessoa(6, "12775766963", "Sylas", "081458713963", null);
        pessoa2.setIdPessoa(6);
        this.pessoaService.alterarNomeETelefone(pessoa2, 7);
        Assertions.assertThat(pessoaService.buscarPessoaPorId(pessoa2.getIdPessoa())).isEqualTo(7);

    }

    @Test
    public void removerPessoaPorIdTest() {
        Pessoa pessoa2 = new Pessoa(6, "12775766963", "Sylas", "081458713963", null);
        this.pessoaService.removerPessoaPorId(6);
        Assertions.assertThat(pessoaService.buscarPessoaPorId(pessoa2.getIdPessoa())).isNull();

    }



}
