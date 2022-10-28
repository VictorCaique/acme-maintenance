package com.acme.maintenance.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "VOO")
public class Voo {
	
	@Id
	@NonNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private float minutosVoo;
	private String destino;
	private String partida;
	private Date data_partida;
	private Date data_chegada;
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "id_aviao", nullable = true)
	private Aviao aviao;

	public Voo() {
		super();
	}

	public Voo(int id, float minutosVoo, String destino, String partida, Date data_partida, Date data_chegada,
			Aviao aviao) {
		super();
		this.id = id;
		this.minutosVoo = minutosVoo;
		this.destino = destino;
		this.partida = partida;
		this.data_partida = data_partida;
		this.data_chegada = data_chegada;
		this.aviao = aviao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getMinutosVoo() {
		return minutosVoo;
	}

	public void setMinutosVoo(float minutosVoo) {
		this.minutosVoo = minutosVoo;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getPartida() {
		return partida;
	}

	public void setPartida(String partida) {
		this.partida = partida;
	}

	public Date getData_partida() {
		return data_partida;
	}

	public void setData_partida(Date data_partida) {
		this.data_partida = data_partida;
	}

	public Date getData_chegada() {
		return data_chegada;
	}

	public void setData_chegada(Date data_chegada) {
		this.data_chegada = data_chegada;
	}

	public Aviao getAviao() {
		return aviao;
	}

	public void setAviao(Aviao aviao) {
		this.aviao = aviao;
	}

	@Override
	public String toString() {
		return "Voo [id=" + id + ", minutosVoo=" + minutosVoo + ", destino=" + destino + ", partida=" + partida
				+ ", data_partida=" + data_partida + ", data_chegada=" + data_chegada + ", aviao=" + aviao + "]";
	}

}
