package com.acme.maintenance.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.acme.maintenance.model.Notificacao;
import com.acme.maintenance.repository.NotificacaoRepository;

@Service
public class NotificacaoService {
	
	@Autowired
	private NotificacaoRepository notificacaoRepository;
	
	public ResponseEntity<Object> findAll() {
		List<Notificacao> dbManutencoes = notificacaoRepository.findAll();
		if(dbManutencoes.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(dbManutencoes, HttpStatus.OK);
	}
	
	public Notificacao save(Notificacao man) {
		return notificacaoRepository.save(man);
	}
	
	public Optional<Notificacao> findById(int id) {
		return notificacaoRepository.findById(id);
	}
	
	public void deleteById(int id) {
		notificacaoRepository.deleteById(id);
	}
}
