package com.acme.maintenance.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.acme.maintenance.model.Tecnico;
import com.acme.maintenance.repository.TecnicoRepository;

@Service
public class TecnicoService {

	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	public ResponseEntity<Object> findAll() {
		List<Tecnico> dbManutencoes = tecnicoRepository.findAll();
		if(dbManutencoes.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(dbManutencoes, HttpStatus.OK);
	}
	
	public Tecnico save(Tecnico man) {
		return tecnicoRepository.save(man);
	}
	
	public Optional<Tecnico> findById(int id) {
		return tecnicoRepository.findById(id);
	}
	
	public void deleteById(int id) {
		tecnicoRepository.deleteById(id);
	}
	
}
