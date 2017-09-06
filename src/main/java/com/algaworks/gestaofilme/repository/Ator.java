package com.algaworks.gestaofilme.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.gestaofilme.model.Atores;

public interface Ator extends JpaRepository<Atores, Long> {
}