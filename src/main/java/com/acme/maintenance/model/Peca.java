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

import org.springframework.lang.NonNull;

@Entity
public class Peca {

	@Id
	@NonNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int nserie;
	@ManyToOne
	@JoinColumn(name = "aviao_id")
	private Aviao aviao;
	@ManyToMany(mappedBy = "componentes")
	private List<Relatorio> relatorios;
	private String fabricante;
	private float horas_uso_peca;
	private String fornecedor;
	private String lote;
	private float valor;
	private String tipo;
	private boolean isActive;
	private Date dataInicio;
	private Date dataVencimento;

	public Peca() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Aviao getAviao() {
		return aviao;
	}

	public void setAviao(Aviao aviao) {
		this.aviao = aviao;
	}

	public List<Relatorio> getRelatorios() {
		return relatorios;
	}

	public void setRelatorios(List<Relatorio> relatorios) {
		this.relatorios = relatorios;
	}

	public int getNserie() {
		return nserie;
	}

	public void setNserie(int nserie) {
		this.nserie = nserie;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public float getHoras_uso_peca() {
		return horas_uso_peca;
	}

	public void setHoras_uso_peca(float horas_uso_peca) {
		this.horas_uso_peca = horas_uso_peca;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Peca [nserie=" + nserie + ", fabricante=" + fabricante + ", horas_uso_peca=" + horas_uso_peca
				+ ", fornecedor=" + fornecedor + ", lote=" + lote + ", valor=" + valor + ", tipo=" + tipo + "]";
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

}
