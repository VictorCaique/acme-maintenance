package com.acme.maintenance.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "NOTIFICACAO", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Notificacao {
	@Id
	@NonNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String notificacao;
	private String obs;
	@ManyToOne
	@JoinColumn(name = "manutencao_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Manutencao manutecao;

	public Notificacao() {
		super();
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNotificacao() {
		return notificacao;
	}

	public void setNotificacao(String notificacao) {
		this.notificacao = notificacao;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public Manutencao getManutecao() {
		return manutecao;
	}

	public void setManutecao(Manutencao manutecao) {
		this.manutecao = manutecao;
	}

	@Override
	public String toString() {
		return "Notificacao [id=" + id + ", notificacao=" + notificacao + ", obs=" + obs + ", manutecao=" + manutecao
				+ "]";
	}

}
