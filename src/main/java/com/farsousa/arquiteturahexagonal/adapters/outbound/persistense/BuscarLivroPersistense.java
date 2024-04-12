package com.farsousa.arquiteturahexagonal.adapters.outbound.persistense;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.farsousa.arquiteturahexagonal.adapters.outbound.persistense.entity.LivroEntity;
import com.farsousa.arquiteturahexagonal.adapters.outbound.persistense.repository.LivroRepository;
import com.farsousa.arquiteturahexagonal.core.domains.Livro;
import com.farsousa.arquiteturahexagonal.core.ports.outbound.BuscarLivroPersistensePort;

public class BuscarLivroPersistense implements BuscarLivroPersistensePort {
	
	private final LivroRepository repository;
	
	public BuscarLivroPersistense(LivroRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Livro> execute(String autor, String titulo, Long id) {
		List<LivroEntity> livros = new ArrayList<>();
		
		if(autor == null && titulo == null && id == null) {
			livros = repository.findAll();
		}
		
		if(autor != null && titulo != null && id != null) {
			livros = repository.findByAutorAndTituloAndId(autor, titulo, id);
		}
		
		if(autor != null && titulo != null) {
			livros = repository.findByAutorAndTitulo(autor, titulo);
		}
		
		if(autor != null && id != null) {
			livros = repository.findByAutorAndId(autor, id);
		}
		
		if(titulo != null && id != null) {
			livros = repository.findByTituloAndId(titulo, id);
		}
		
		if(autor != null) {
			livros = repository.findByAutor(autor);
		}
		
		if(titulo != null) {
			livros = repository.findByTitulo(titulo);
		}
		
		if(id != null) {
			Optional<LivroEntity> livro = repository.findById(id);
			if(livro.isPresent()) livros.add(livro.get());
		}
		
		return livros.stream().map(LivroEntity::toDomain).toList();
	}

}
