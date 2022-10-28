package com.acme.maintenance.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acme.maintenance.model.Notificacao;
import com.acme.maintenance.service.NotificacaoService;

@RestController
@RequestMapping("/notificacao")
public class ControleNotificacao {
	
	@Autowired
	private NotificacaoService notificacaoService;
	
	@GetMapping("/")
	public ResponseEntity<Object> findAll(){
		return notificacaoService.findAll();
	}
	
	@PostMapping("/")
	public Notificacao addNotificacao(@RequestBody Notificacao not) {
		return notificacaoService.save(not);
	}
	
	@PutMapping("/{id}")
	public Notificacao updateNotificacao(@PathVariable int id, @RequestBody Notificacao newNot) {
		return notificacaoService.findById(id).map((not) -> {
			not.setManutecao(newNot.getManutecao());
			not.setNotificacao(newNot.getNotificacao());
			not.setObs(newNot.getObs());
			return notificacaoService.save(not);
		}).orElseGet(() -> {
			newNot.setId(id);
			return notificacaoService.save(newNot);
		});
	}
	
	@DeleteMapping("/{id}")
	public void deleteNotificacao(@PathVariable int id) {
		notificacaoService.deleteById(id);
	}
	
	@GetMapping("/{id}")
	public Optional<Notificacao> findById(@PathVariable int id) {
		return notificacaoService.findById(id);
	}
}
