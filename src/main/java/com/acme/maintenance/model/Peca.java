package com.acme.maintenance.model;

import java.time.LocalDate;
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

import org.springframework.lang.NonNull;

@Entity
@Table(name = "PECA", uniqueConstraints = @UniqueConstraint(columnNames = { "id", "nserie" }))
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
	private String descricao;
	private float horas_uso_peca;
	private String fornecedor;
	private String lote;
	private float valor;
	private String tipo;
	private boolean isActive;
	private LocalDate dataInicio;
	private LocalDate dataVencimento;
	private int tempoValidade;
	
	

	public Peca(int id, int nserie, Aviao aviao, List<Relatorio> relatorios, String fabricante, float horas_uso_peca,
			String fornecedor, String lote, float valor, String tipo, boolean isActive, LocalDate dataInicio,
			LocalDate dataVencimento, int tempoValidade) {
		super();
		this.id = id;
		this.nserie = nserie;
		this.aviao = aviao;
		this.relatorios = relatorios;
		this.fabricante = fabricante;
		this.horas_uso_peca = horas_uso_peca;
		this.fornecedor = fornecedor;
		this.lote = lote;
		this.valor = valor;
		this.tipo = tipo;
		this.isActive = isActive;
		this.dataInicio = dataInicio;
		this.dataVencimento = dataVencimento;
		this.tempoValidade = tempoValidade;
	}

	public int getTempoValidade() {
		return tempoValidade;
	}

	public void setTempoValidade(int tempoValidade) {
		this.tempoValidade = tempoValidade;
	}

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

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
