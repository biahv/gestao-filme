package com.algaworks.gestaofilme.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.algaworks.gestaofilme.model.Ator;


public interface Atores extends JpaRepository<Ator, Long>{
	
	@Query(value = "SELECT * "
			+ " FROM ator c "
			+ " ORDER BY c.id_ator", nativeQuery = true)
	List<Ator>  findAllOrderByAtor();

}
 