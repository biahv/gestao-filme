package com.algaworks.gestaofilme.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Atores {
	
	@Id
	@GeneratedValue
	@Column(name="id_atores")
	private Long idAtoress;
	
	@NotEmpty(message="Nome obrigatório!")
	private String nome;
	
	@NotEmpty(message="Email obrigatório!")
	private String email;
	
	@NotEmpty(message="Site obrigatório!")
	private String site;

	public Long getIdAtoress() {
		return idAtoress;
	}

	public void setIdAtoress(Long idAtoress) {
		this.idAtoress = idAtoress;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

}
