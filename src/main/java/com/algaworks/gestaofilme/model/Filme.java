package com.algaworks.gestaofilme.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Filme {
	
	@Id
	@GeneratedValue
	private Long idFilme;
	
	@ManyToOne
	@JoinColumn(name = "id_ator")
	@NotNull(message="Ator obrigatório!")
	private Ator ator;
	
	@NotEmpty(message="Nome Filme obrigatório!")
	private String nomeFilme;
	
	@NotNull(message = "Data Lançamento é obrigatória")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE )
	private Date dataL;

	public Long getIdFilme() {
		return idFilme;
	}

	public void setIdFilme(Long idFilme) {
		this.idFilme = idFilme;
	}

	public Ator getAtor() {
		return ator;
	}

	public void setAtor(Ator ator) {
		this.ator = ator;
	}

	public String getNomeFilme() {
		return nomeFilme;
	}

	public void setNomeFilme(String nomeFilme) {
		this.nomeFilme = nomeFilme;
	}

	public Date getDataL() {
		return dataL;
	}

	public void setDataL(Date dataL) {
		this.dataL = dataL;
	}
	
	
	
}
