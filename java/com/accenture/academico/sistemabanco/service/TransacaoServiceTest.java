package com.accenture.academico.sistemabanco.service;


import com.accenture.academico.sistemabanco.model.Transacao;

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

  
    
public class TransacaoServiceTest {

    @Autowired
    private TransacaoService TransacaoService;
    @Rule
    @Deprecated
    public ExpectedException thrown = ExpectedException.none();

  
        
    @Test
    public void cadastrarTransacaotest() {
        Transacao transacao = new Transacao(9, null, 12/03/1998, 450.56, null);
        this.TransacaoService.cadastrarTransacao(transacao, 9);
        Assertions.assertThat(transacao.getDataHoraMovimentacao()).isNotNull();

        
    }

}
    