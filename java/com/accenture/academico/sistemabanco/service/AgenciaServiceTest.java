package com.accenture.academico.sistemabanco.service;



import com.accenture.academico.sistemabanco.model.Agencia;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;

import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@SpringBootTest
@RunWith(SpringRunner.class)
//@DataJpaTest
public class AgenciaServiceTest {
    @Autowired
    private AgenciaService agenciaService;
    @Rule
    @Deprecated
    public ExpectedException thrown = ExpectedException.none();


    
    @Test
    public void CadastrarAgenciatest() {
        Agencia agencia = new Agencia(5, 1002, "lua_agencia", "Rua teste dos testes", "083458712963",null);
        this.agenciaService.cadastrarAgencia(agencia);
        Assertions.assertThat(agencia.getIdAgencia()).isNotNull();
        Assertions.assertThat(agencia.getIdAgencia()).isEqualTo(5);
        Assertions.assertThat(agencia.getEndereco()).isEqualTo("Rua teste dos testes");
        Assertions.assertThat(agencia.getNomeAgencia()).isEqualTo("lua_agencia");
        Assertions.assertThat(agencia.getTelefone()).isNotNull();

    }
    
   
   
    @Test
    public void buscarAgenciaPorIdTest(){
        Agencia agencia = new Agencia(5120, 1000, "lua", "Rua teste dos testes", " 083996738691", null);
        this.agenciaService.buscarAgenciaPorId(5120);
        Assertions.assertThat(agenciaService.buscarAgenciaPorId(agencia.getIdAgencia())).isEqualTo(5120);
        
    }
    
    @Test
    public void atualizarAgenciaTest(){
        Agencia agencia1 = new Agencia(6170, 2000, "Sol", "Rua teste dos testes ao lado do teste", " 083996738697", null);
        this.agenciaService.atualizarAgencia(agencia1);
        agenciaService.buscarAgenciaPorId(6170);
        Assertions.assertThat(agenciaService.buscarAgenciaPorId(agencia1.getIdAgencia())).isEqualTo(6170);


        



    }

    @Test
    public void DeletarAgenciaTest() {
        Agencia agencia = new Agencia(5120, 1000, "lua", "Rua teste dos testes", " 083996738691", null);
        this.agenciaService.removerAgenciaPorId(5120);
        Assertions.assertThat(agenciaService.buscarAgenciaPorId(agencia.getIdAgencia())).isNull();

    }



    

}
