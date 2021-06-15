package com.accenture.academico.sistemabanco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.academico.sistemabanco.model.Agencia;
import com.accenture.academico.sistemabanco.repository.AgenciaRepository;

@Service
public class AgenciaService {
	
	@Autowired
	private AgenciaRepository repository;

	public void cadastrarAgencia(Agencia agencia) {
		repository.save(agencia);
	}
	
	public List<Agencia> buscarTodasAsAgencias() {		
		return repository.findAll();
	}
	
	public Agencia buscarAgenciaPorId(Integer id) {
		return repository.findById(id).get();
	}
	
	public Agencia atualizarAgencia(Agencia agencia) {
		buscarAgenciaPorId(agencia.getIdAgencia());
		return repository.save(agencia);		
	}
	
	public void removerAgenciaPorId(Integer id) {
		repository.deleteById(id);
	}

}
