package com.algaworks.gestaofilme.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;



@Entity
public class Ator {
	
	@Id
	@GeneratedValue
	@Column(name="id_ator")
	private Long idAtor;
	@NotEmpty(message="Nome obrigatório!")
	private String nome;
	
	@NotEmpty(message="Email obrigatório!")
	private String email;
	
	@NotNull(message = "Site é obrigatória")
	private String site;
	
	
	@OneToMany(mappedBy = "ator", cascade = CascadeType.ALL)
	private Set<Filme> filmes;


	public Long getIdAtor() {
		return idAtor;
	}


	public void setIdAtor(Long idAtor) {
		this.idAtor = idAtor;
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


	public Set<Filme> getFilmes() {
		return filmes;
	}


	public void setFilmes(Set<Filme> filmes) {
		this.filmes = filmes;
	}
	
	

}
