package com.acme.maintenance.model;

import java.util.Date;

public class SearchParams {
	private Date date;
	private String motivo;
	private int aviaoId;
	private int numMan;
	
	
	
	public SearchParams() {
		super();
	}
	public SearchParams(Date date, int aviaoId, String motivo, int numMan) {
		super();
		this.date = date;
		this.motivo = motivo;
		this.aviaoId = aviaoId;
		this.numMan = numMan;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public int getAviaoId() {
		return aviaoId;
	}
	public void setAviaoId(int aviaoId) {
		this.aviaoId = aviaoId;
	}
	public int getNumMan() {
		return numMan;
	}
	public void setNumMan(int numMan) {
		this.numMan = numMan;
	}
	
	
}
