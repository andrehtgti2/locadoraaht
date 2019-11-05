package br.com.andretanaka.locadoraaht.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
 * by Andre Hiroshi Tanaka
 * andrehtgti2@gmail.com
 * www.andretanaka.com.br
 * 
 */

@Entity(name="locacao")
public class LocacaoEntity  implements Serializable{
	
	
	
	public LocacaoEntity() {
		super();
	}

	public LocacaoEntity(String nome, Date inicio, Date fim) {
		super();
		this.nome = nome;
		this.inicio = inicio;
		this.fim = fim;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="inicio")
	private Date inicio;
	
	@Column(name="fim")		
	private Date fim;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}

	
	
	

}
