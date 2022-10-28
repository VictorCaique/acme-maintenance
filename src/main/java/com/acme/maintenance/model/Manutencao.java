package com.acme.maintenance.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

enum Frequencia {
	DIARIA,
	SEMANAL,
	QUINZENAL,
	MENSAL,
	NAOREPETE
}

@Entity
@Table(name = "MANUTENCAO", uniqueConstraints = @UniqueConstraint(columnNames = { "id" }))
public class Manutencao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String motivoManutencao;
	private Date data;
	private String observacoes;
	@ManyToMany(mappedBy = "manutencoes")
	private List<Aviao> avioes;
	private Frequencia frequencia;
	@ManyToOne
	@JoinColumn(name = "aviao_id")
	private Tecnico tecnico;
	
	public Manutencao() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMotivoManutencao() {
		return motivoManutencao;
	}

	public void setMotivoManutencao(String motivoManutencao) {
		this.motivoManutencao = motivoManutencao;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public List<Aviao> getAvioes() {
		return avioes;
	}

	public void setAvioes(List<Aviao> avioes) {
		this.avioes = avioes;
	}

	public Frequencia getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(Frequencia frequencia) {
		this.frequencia = frequencia;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	@Override
	public String toString() {
		return "Manutencao [id=" + id + ", motivoManutencao=" + motivoManutencao 
				+ ", observacoes=" + observacoes + ", avioes=" + avioes + ", frequencia=" + frequencia + "]";
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
}
