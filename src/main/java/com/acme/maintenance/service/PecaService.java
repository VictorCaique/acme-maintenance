package com.acme.maintenance.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.acme.maintenance.model.Peca;
import com.acme.maintenance.repository.PecaRepository;

@Service
public class PecaService {

	@Autowired
	private PecaRepository pecaRepository;
	
	public ResponseEntity<Object> getAllPeca(){
		List<Peca> dbPecas = pecaRepository.findAll();
		if(dbPecas.isEmpty())
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(dbPecas, HttpStatus.OK);
	}
	
	public Peca save(Peca pec) {
		return pecaRepository.save(pec);
	}
	
	public Optional<Peca> getPecaById(int id) {
		return pecaRepository.findById(id);
	}
	
	public void deletePecaById(int id) {
		pecaRepository.deleteById(id);
	}
}
