package br.com.andretanaka.locadoraaht.util;

import java.util.Date;

/*
 * by Andre Hiroshi Tanaka
 * andrehtgti2@gmail.com
 * www.andretanaka.com.br
 * 
 */

public class ValueObjectDateAHT {
	
	
	
	private Date dataFuturo;
	private Date dataPassado;
	private int difDias;
	private int difMeses;
	private int difAnos;
	private int difHoras;
	private int difMinutos;
	private int difSegundos;
	private int difMilissegundos;
	public ValueObjectDateAHT(Date dataFuturo, Date dataPassado, int difDias, int difMeses, int difAnos, int difHoras, int difMinutos, int difSegundos, int difMilissegundos) {
		super();
		this.dataFuturo = dataFuturo;
		this.dataPassado = dataPassado;
		this.difDias = difDias;
		this.difMeses = difMeses;
		this.difAnos = difAnos;
		this.difHoras = difHoras;
		this.difMinutos = difMinutos;
		this.difSegundos = difSegundos;
		this.difMilissegundos = difMilissegundos;
	}
	
	
	public Date getDataFuturo() {
		return dataFuturo;
	}
	public Date getDataPassado() {
		return dataPassado;
	}
	public int getDifDias() {
		return difDias;
	}
	public int getDifMeses() {
		return difMeses;
	}
	public int getDifAnos() {
		return difAnos;
	}
	public int getDifHoras() {
		return difHoras;
	}
	public int getDifMinutos() {
		return difMinutos;
	}
	public int getDifSegundos() {
		return difSegundos;
	}
	public int getDifMilissegundos() {
		return difMilissegundos;
	}
	
	
	
	

}

