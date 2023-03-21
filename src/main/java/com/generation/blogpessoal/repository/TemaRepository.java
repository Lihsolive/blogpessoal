package com.generation.blogpessoal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.generation.blogpessoal.model.Tema;

@EnableJpaRepositories(basePackages = "com.acme.repositories.jpa")
@Repository
public interface TemaRepository extends JpaRepository<Tema, Long>{
	
	public List<Tema>finAlByDescricaoContainingIgnoreCase(@Param("descricao") String descricao);
	//Essse método seria o mesmo que:
	//SELECT * FROM tb_temass WHERE descricao LIKE "%descricao%";
}