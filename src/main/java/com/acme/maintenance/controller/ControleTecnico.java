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

import com.acme.maintenance.model.Tecnico;
import com.acme.maintenance.service.TecnicoService;

@RestController
@RequestMapping("/tecnico")
public class ControleTecnico {
	
	@Autowired
	private TecnicoService tecnicoService;
	
	@GetMapping("/")
	public ResponseEntity<Object> findAll(){
		return tecnicoService.findAll();
	}
	
	@PostMapping("/")
	public Tecnico addTecnico(@RequestBody Tecnico tec) {
		return tecnicoService.save(tec);
	}
	
	@PutMapping("/{id}")
	public Tecnico updateTecnico(@PathVariable int id, @RequestBody Tecnico newTec) {
		return tecnicoService.findById(id).map((tec) -> {
			tec.setCpf(newTec.getCpf());
			tec.setManutencoes(newTec.getManutencoes());
			tec.setNome(newTec.getNome());
			tec.setTelefone(newTec.getTelefone());
			return tecnicoService.save(tec);
		}).orElseGet(() -> {
			newTec.setId(id);
			return tecnicoService.save(newTec);
		});
	}
	
	@DeleteMapping("/{id}")
	public void deleteTecnico(@PathVariable int id) {
		tecnicoService.deleteById(id);
	}
	
	@GetMapping("/{id}")
	public Optional<Tecnico> findById(@PathVariable int id) {
		return tecnicoService.findById(id);
	}
}
