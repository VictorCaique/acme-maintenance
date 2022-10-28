package com.acme.maintenance.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.acme.maintenance.model.Aviao;
import com.acme.maintenance.repository.AviaoRepository;

@Service
public class AviaoService {

	@Autowired
	private AviaoRepository aviaoRepository;
	
	public ResponseEntity<Object> getAllAviao() {
		List<Aviao> dbManutencoes = aviaoRepository.findAll();
		if(dbManutencoes.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(dbManutencoes, HttpStatus.OK);
	}
	
	public Aviao save(Aviao man) {
		return aviaoRepository.save(man);
	}
	
	public Optional<Aviao> getAviaoById(int id) {
		return aviaoRepository.findById(id);
	}
	
	public void deleteAviaoById(int id) {
		aviaoRepository.deleteById(id);
	}
	
}
