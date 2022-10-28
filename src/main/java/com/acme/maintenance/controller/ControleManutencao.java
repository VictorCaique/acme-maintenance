package com.acme.maintenance.controller;

import java.util.Date;
import java.util.NoSuchElementException;
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

import com.acme.maintenance.model.Manutencao;
import com.acme.maintenance.model.Notificacao;
import com.acme.maintenance.service.ManutencaoService;
import com.acme.maintenance.service.NotificacaoService;
import com.acme.maintenance.service.TecnicoService;

@RestController
@RequestMapping("/manutencao")
public class ControleManutencao {
	
	@Autowired
	private ManutencaoService manutencaoService;
	
	@Autowired
	private TecnicoService tecnicoService;
	
	@Autowired
	private NotificacaoService notificacaoService;
	
	@GetMapping("/")
	public ResponseEntity<Object> getAllManutencoes() {
		return manutencaoService.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Manutencao> getManutencaoById(@PathVariable int id) {
		return manutencaoService.findById(id);
	}
	
	@PostMapping("/")
	public Manutencao createManutencao(@RequestBody Manutencao newMan) {
		return manutencaoService.save(newMan);
	}
	
	@PutMapping("/{id}")
	public Manutencao updateManutencao(@PathVariable int id, @RequestBody Manutencao newMan) {
			return manutencaoService.findById(id).map((man) -> {
				man.setAvioes(newMan.getAvioes());
				man.setFrequencia(newMan.getFrequencia());
				man.setMotivoManutencao(newMan.getMotivoManutencao());
				man.setObservacoes(newMan.getObservacoes());
				man.setTecnico(newMan.getTecnico());
				man.setData(newMan.getData());
				return manutencaoService.save(man);
			}).orElseGet(() -> {
				newMan.setId(id);
				return manutencaoService.save(newMan);
			});
	}
	
	@DeleteMapping("/{id}")
	public void deleteManutencao(@PathVariable int id) {
		manutencaoService.deleteById(id);
	}
	
	@PostMapping("/{id}/tecnico/{idTecnico}")
	public Manutencao atribuirTecnico(@PathVariable int id, @PathVariable int idTecnico) {
		return manutencaoService.findById(id).map((man) -> {
			man.setTecnico(tecnicoService.findById(idTecnico).get());
			return manutencaoService.save(man);
		}).orElseThrow(() -> {
			return new NoSuchElementException();
		});
	}
	
	@DeleteMapping("{id}/tecnico/{idTecnico}")
	public void desatribuirTecnico(@PathVariable int id, @PathVariable int idTecnico) {
		manutencaoService.findById(id).get().setTecnico(null);
	}
	
	@GetMapping("/manutencoesFuturas")
	public ResponseEntity<Object> buscarManutencoesFuturas(){
		return manutencaoService.findFutureManutencoes(new Date());
	}
	
	@PostMapping("/{id}/notificar")
	public Notificacao notificarManutencao(@PathVariable int id, @RequestBody Notificacao newNot) {
		newNot.setManutecao(manutencaoService.findById(id).get());
		return notificacaoService.save(newNot);
	}
	
	@DeleteMapping("/notificar/{idNot}")
	public void apagarNotificacao(@PathVariable int idNot) {
		notificacaoService.deleteById(idNot);
	}
	
}
