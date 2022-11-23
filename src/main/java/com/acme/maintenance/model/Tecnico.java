package com.acme.maintenance.model;

import java.time.LocalDate;
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
@Table(name = "TECNICO", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Tecnico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	public String nome;
	public LocalDate dataNasc;
	public String cpf;
	public String telefone;
	public String endereco;
	public String setor;
	public String especializacao;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "manutencao_id", referencedColumnName = "id")
	public List<Manutencao> manutencoes;
	
	public Tecnico() {
		super();
	}

	public Tecnico(int id) {
		super();
		this.id = id;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Manutencao> getManutencoes() {
		return manutencoes;
	}

	public void setManutencoes(List<Manutencao> manutencoes) {
		this.manutencoes = manutencoes;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public String getEspecializacao() {
		return especializacao;
	}

	public void setEspecializacao(String especializacao) {
		this.especializacao = especializacao;
	}

	public LocalDate getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}

	@Override
	public String toString() {
		return "Tecnico [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", telefone=" + telefone + "]";
	}
	
	
	
}
