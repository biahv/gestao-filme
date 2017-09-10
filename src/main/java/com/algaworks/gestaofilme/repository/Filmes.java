package com.algaworks.gestaofilme.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.gestaofilme.model.Filme;

public interface Filmes extends JpaRepository<Filme, Long> {

}
