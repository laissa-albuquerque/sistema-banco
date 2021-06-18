package com.accenture.academico.sistemabanco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.accenture.academico.sistemabanco.model.Agencia;
import com.accenture.academico.sistemabanco.repository.AgenciaRepository;
import com.accenture.academico.sistemabanco.service.exception.EntityNotFoundException;
import com.accenture.academico.sistemabanco.service.exception.NegocioException;

import lombok.SneakyThrows;

@Service
public class AgenciaService {
	
	@Autowired
	private AgenciaRepository repository;

	@SneakyThrows
	public Agencia cadastrarAgencia(Agencia agencia) {
			Agencia agenciaPersistida = repository.save(agencia);
			
			if (agenciaPersistida == null) {
				throw new NegocioException("Erro ao salvar agência");
			}
			
			return agenciaPersistida;		
	}
	
	public List<Agencia> buscarTodasAsAgencias() {		
		return repository.findAll();
	}
	
	@SneakyThrows
	public Agencia buscarAgenciaPorId(Integer id) {
				
		return repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Agência não encontrada"));
	}
	
	@SneakyThrows
	public Agencia atualizarAgencia(Agencia agencia) {
		buscarAgenciaPorId(agencia.getIdAgencia());		
		Agencia agenciaAtualizada = repository.save(agencia);
		
		if (agenciaAtualizada == null) {
			throw new NegocioException("Erro ao atualizar agência");
		}
		return agenciaAtualizada;		
	}
	
	@SneakyThrows
	public void removerAgenciaPorId(Integer id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntityNotFoundException("É necessário informar um ID válido para exclusão da agência");
		}		
	}
}
