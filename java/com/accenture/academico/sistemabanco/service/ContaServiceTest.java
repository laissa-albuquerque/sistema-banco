package com.accenture.academico.sistemabanco.service;

import com.accenture.academico.sistemabanco.model.Conta;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;

import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)

public class ContaServiceTest {

    @Autowired
    private ContaService contaService;
    @Rule
    @Deprecated
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void cadastrarContatest() {
        Conta conta = new Conta(9, 78456, 46, 452.17, null, null);
        this.contaService.cadastrarConta(conta, 9);
        Assertions.assertThat(conta.getIdConta()).isNotNull();
        Assertions.assertThat(conta.getNumeroConta()).isEqualTo(78456);
        Assertions.assertThat(conta.getDigitoVerificador()).isEqualTo(46);
        Assertions.assertThat(conta.getSaldo()).isEqualTo(1000.56);

    }

    
    @Test
    public void buscarContaPorIdTest(){
        Conta conta = new Conta(9, 78456, 46, 452.17, null, null);
        conta.setIdConta(9);
        this.contaService.buscarContaPorId(9);
        Assertions.assertThat(contaService.buscarContaPorId(conta.getIdConta())).isEqualTo(9);
        
    }

    @Test
    public void buscarContaPorNumeroTest(){
        Conta conta = new Conta(9, 78456, 46, 452.17, null, null);
        conta.setNumeroConta(78456);
        this.contaService.buscarContaPorNumero(78456);
        Assertions.assertThat(contaService.buscarContaPorNumero(conta.getNumeroConta())).isEqualTo(78456);
        
    }

    @Test
    public void removerContaPorIdTest() {
        Conta conta = new Conta(9, 78456, 46, 452.17, null, null);
        this.contaService.removerContaPorId(9);
        Assertions.assertThat(contaService.buscarContaPorId(conta.getIdConta())).isNull();

    }

    @Test
    public void realizarDepositoTest() {
        Conta conta = new Conta(9, 78456, 46, 452.17, null, null);
        this.contaService.realizarDeposito(9, 150.0);
        Assertions.assertThat(contaService.buscarContaPorId(conta.getIdConta())).isEqualTo(602.17);

    }

    @Test
    public void realizarSaquetest(){
        Conta conta = new Conta(9, 78456, 46, 602.17, null, null);
        this.contaService.realizarSaque(9, 300.0 );
        Assertions.assertThat(contaService.buscarContaPorId(conta.getIdConta())).isEqualTo(302.17);

    }


    @Test
    public void realizarTransferenciatest(){
        Conta conta = new Conta(9, 78456, 46, 302.17, null, null);
        Conta conta2 = new Conta(10, 88458, 71, 1102.24, null, null);
        this.contaService.realizarTransferencia(conta, conta2, 100.0);
        Assertions.assertThat(contaService.buscarContaPorId(conta.getIdConta())).isEqualTo(202.17);
        Assertions.assertThat(contaService.buscarContaPorId(conta2.getIdConta())).isEqualTo(1202.24);

    }




}
