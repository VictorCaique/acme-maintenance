package com.acme.maintenance.controller;

import java.time.LocalDate;
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

import com.acme.maintenance.model.Aviao;
import com.acme.maintenance.model.Peca;
import com.acme.maintenance.service.AviaoService;
import com.acme.maintenance.service.PecaService;

@RestController
@RequestMapping("/aviao")
public class ControleAviao {

	@Autowired
	private AviaoService aviaoService;

	@Autowired
	private PecaService pecaService;

	/* Função de busca de todos aviões */
	@GetMapping("/")
	public ResponseEntity<Object> getAllAviao() {
		return aviaoService.getAllAviao();
	}

	/* Função de inserção de aviões */
	@PostMapping("/")
	public Aviao newAviao(@RequestBody Aviao avi) {
		return aviaoService.save(avi);
	}

	/* Função de busca de avião por id */
	@GetMapping("/{id}")
	public Optional<Aviao> getAviaoById(@PathVariable int id) {
		return aviaoService.getAviaoById(id);
	}

	/* Função de busca de peca por nserie */
	@GetMapping("/nserie/{nserie}")
	public ResponseEntity<Object> findByNSerie(@PathVariable int nserie) {
		return aviaoService.findByNSerie(nserie);
	}	
	
	/* Função de exclusão de avião */
	@DeleteMapping("/{id}")
	public void deleteAviaoById(@PathVariable int id) {
		aviaoService.deleteAviaoById(id);
	}

	/* Função de edição de avião */
	@PutMapping("/{id}")
	public Aviao updateAviao(@PathVariable int id, @RequestBody Aviao newAvi) {
		return aviaoService.getAviaoById(id).map((avi) -> {
			avi.setComponentes(newAvi.getComponentes());
			avi.setData_notificacao(newAvi.getData_notificacao());
			avi.setFabricante(newAvi.getFabricante());
			avi.setManutencoes(newAvi.getManutencoes());
			avi.setModelo(newAvi.getModelo());
			avi.setNotificacao(newAvi.getNotificacao());
			avi.setNserie(newAvi.getNserie());
			avi.setObservacoes(newAvi.getObservacoes());
			avi.setQuantidade_assentos(newAvi.getQuantidade_assentos());
			avi.setTamanho_asa(newAvi.getTamanho_asa());
			avi.setTamanho_total(newAvi.getTamanho_total());
			avi.setVelocidade(newAvi.getVelocidade());
			return aviaoService.save(avi);
		}).orElseGet(() -> {
			newAvi.setId(id);
			return aviaoService.save(newAvi);
		});
	}

	/* Função de inserção de peça do avião */
	@PostMapping("/{id}/peca")
	public Peca newPeca(@PathVariable int id, @RequestBody Peca newPeca) {
		return aviaoService.getAviaoById(id).map((avi) -> {
			Peca savedPeca = pecaService.save(newPeca);
			avi.getComponentes().add(savedPeca);
			aviaoService.save(avi);
			return savedPeca;
		}).orElseThrow(() -> {
			return new NoSuchElementException();
		});
	}

	/* Função de inicializar peca do avião */
	@PostMapping("/{id}/peca/{idPeca}/init")
	public Peca initPeca(@PathVariable int id, @PathVariable int idPeca, @RequestBody Peca newPeca) {
		return aviaoService.getAviaoById(id).map((avi) -> {
			return pecaService.getPecaById(idPeca).map((pec) -> {
				pec.setActive(true);
				LocalDate lt = LocalDate.now();
				pec.setDataInicio(lt);
				pec.setDataVencimento(lt.plusYears(newPeca.getTempoValidade()));
				return pecaService.save(pec);
			}).orElseThrow(() -> {
				return new NoSuchElementException();
			});
		}).orElseThrow(() -> {
			return new NoSuchElementException();
		});
	}
	
	@DeleteMapping("/{id}/peca/{idPeca}")
	public void removePeca(@PathVariable int id, @PathVariable int idPeca) {
		pecaService.deletePecaById(idPeca);
	}
	
	
}
