package com.farsousa.arquiteturahexagonal.adapters.outbound.persistense.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farsousa.arquiteturahexagonal.adapters.outbound.persistense.entity.LivroEntity;

public interface LivroRepository extends JpaRepository<LivroEntity, Long> {
	
	List<LivroEntity> findByAutor(String autor);
	
	List<LivroEntity> findByTitulo(String titulo);
	
	List<LivroEntity> findByAutorAndTituloAndId(String autor, String titulo, Long id);
	
	List<LivroEntity> findByAutorAndTitulo(String autor, String titulo);
	
	List<LivroEntity> findByAutorAndId(String autor, Long id);
	
	List<LivroEntity> findByTituloAndId(String titulo, Long id);

}
