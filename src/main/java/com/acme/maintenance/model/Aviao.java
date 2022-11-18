package com.acme.maintenance.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "AVIAO", uniqueConstraints = @UniqueConstraint(columnNames = { "id", "nserie" }))
public class Aviao implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int nserie;
	private String fabricante;
	private float tamanho_asa;
	private float tamanho_total;
	private float velocidade;
	private int quantidade_assentos;
	private String modelo;
	private String observacoes;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "peca_id", referencedColumnName = "id")
	private List<Peca> componentes;
	private String notificacao;
	private Date data_notificacao;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "manutencao_id", referencedColumnName = "id")
	private List<Manutencao> manutencoes;

	public Aviao() {
		super();
	}
	
	public Aviao(int id) {
		super();
		this.id = id;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNserie() {
		return nserie;
	}

	public void setNserie(int nserie) {
		this.nserie = nserie;
	}

	public List<Manutencao> getManutencoes() {
		return manutencoes;
	}

	public void setManutencoes(List<Manutencao> manutencoes) {
		this.manutencoes = manutencoes;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public float getTamanho_asa() {
		return tamanho_asa;
	}

	public void setTamanho_asa(float tamanho_asa) {
		this.tamanho_asa = tamanho_asa;
	}

	public float getTamanho_total() {
		return tamanho_total;
	}

	public void setTamanho_total(float tamanho_total) {
		this.tamanho_total = tamanho_total;
	}

	public float getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(float velocidade) {
		this.velocidade = velocidade;
	}

	public int getQuantidade_assentos() {
		return quantidade_assentos;
	}

	public void setQuantidade_assentos(int quantidade_assentos) {
		this.quantidade_assentos = quantidade_assentos;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public List<Peca> getComponentes() {
		return componentes;
	}

	public void setComponentes(List<Peca> componentes) {
		this.componentes = componentes;
	}

	public String getNotificacao() {
		return notificacao;
	}

	public void setNotificacao(String notificacao) {
		this.notificacao = notificacao;
	}

	public Date getData_notificacao() {
		return data_notificacao;
	}

	public void setData_notificacao(Date data_notificacao) {
		this.data_notificacao = data_notificacao;
	}

	@Override
	public String toString() {
		return "Aviao [nserie=" + nserie + ", fabricante=" + fabricante + ", tamanho_asa=" + tamanho_asa
				+ ", tamanho_total=" + tamanho_total + ", velocidade=" + velocidade + ", quantidade_assentos="
				+ quantidade_assentos + ", modelo=" + modelo + ", observacoes=" + observacoes + ", notificacao="
				+ notificacao + ", data_notificacao=" + data_notificacao + "]";
	}

}
