package com.acme.maintenance.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "RELATORIO", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Relatorio {

	@Id
	@NonNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Date data;
	@ManyToMany
    @JoinTable(name = "relatorio_peca",
    joinColumns = { @JoinColumn(name = "fk_relatorio") },
    inverseJoinColumns = { @JoinColumn(name = "fk_peca") })
	private List<Peca> componentes;
	@ManyToOne
	@JoinColumn(name="aviao_id")
	private Aviao aviao;
	private String motivo;
	private double custo;
	private String relatorio;
	private String obs;

	public Relatorio() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public List<Peca> getComponentes() {
		return componentes;
	}

	public void setComponentes(List<Peca> componentes) {
		this.componentes = componentes;
	}

	public Aviao getAviao() {
		return aviao;
	}

	public void setAviao(Aviao aviao) {
		this.aviao = aviao;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public double getCusto() {
		return custo;
	}

	public void setCusto(double custo) {
		this.custo = custo;
	}

	public String getRelatorio() {
		return relatorio;
	}

	public void setRelatorio(String relatorio) {
		this.relatorio = relatorio;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	@Override
	public String toString() {
		return "Relatorio [id=" + id + ", data=" + data + ", componentes=" + componentes + ", aviao=" + aviao
				+ ", motivo=" + motivo + ", custo=" + custo + ", relatorio=" + relatorio + ", obs=" + obs + "]";
	}

}
