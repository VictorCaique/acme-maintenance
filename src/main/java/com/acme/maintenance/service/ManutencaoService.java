package com.acme.maintenance.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.acme.maintenance.model.Manutencao;
import com.acme.maintenance.repository.ManutencaoRepository;

@Service
public class ManutencaoService {
	
	@Autowired
	private ManutencaoRepository manutencaoRepository;
	
	public ResponseEntity<Object> findAll() {
		List<Manutencao> dbManutencoes = manutencaoRepository.findAll();
		if(dbManutencoes.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(dbManutencoes, HttpStatus.OK);
	}
	
	public ResponseEntity<Object> findFutureManutencoes(Date date){
		List<Manutencao> dbManutencoes = manutencaoRepository.findByDataGreaterThan(date);
		if(dbManutencoes.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(dbManutencoes, HttpStatus.OK);
	}

	public ResponseEntity<Object> findByData(Date date){
		List<Manutencao> dbManutencoes = manutencaoRepository.findByData(date);
		if(dbManutencoes.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(dbManutencoes, HttpStatus.OK);
	}

	public ResponseEntity<Object> findByMotivo(String motivo){
		List<Manutencao> dbManutencoes = manutencaoRepository.findByMotivoManutencao(motivo);
		if(dbManutencoes.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(dbManutencoes, HttpStatus.OK);
	}

	public ResponseEntity<Object> findManutencoesSearch(Date date, int aviaoId, String motivo, int numMan){
		List<Manutencao> dbManutencoes = manutencaoRepository.findManutencoesPrint(date, aviaoId, motivo, numMan);
		if(dbManutencoes.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(dbManutencoes, HttpStatus.OK);
	}
	
	public Manutencao save(Manutencao man) {
		return manutencaoRepository.save(man);
	}
	
	public Optional<Manutencao> findById(int id) {
		return manutencaoRepository.findById(id);
	}
	
	public void deleteById(int id) {
		manutencaoRepository.deleteById(id);
	}
}
