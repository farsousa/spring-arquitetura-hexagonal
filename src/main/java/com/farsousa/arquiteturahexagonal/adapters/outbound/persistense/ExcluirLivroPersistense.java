package com.farsousa.arquiteturahexagonal.adapters.outbound.persistense;

import java.util.Optional;

import com.farsousa.arquiteturahexagonal.adapters.outbound.persistense.entity.LivroEntity;
import com.farsousa.arquiteturahexagonal.adapters.outbound.persistense.repository.LivroRepository;
import com.farsousa.arquiteturahexagonal.core.domains.Livro;
import com.farsousa.arquiteturahexagonal.core.exceptions.NaoEncontradoException;
import com.farsousa.arquiteturahexagonal.core.ports.outbound.ExcluirLivroPersistensePort;

public class ExcluirLivroPersistense implements ExcluirLivroPersistensePort {

	private LivroRepository livroRepository;
	
	public ExcluirLivroPersistense(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}

	public Livro execute(Long id) {
		Optional<LivroEntity> livro = livroRepository.findById(id);
		
		if(livro.isEmpty()) throw new NaoEncontradoException("Livro não encontrado!");
		
		livroRepository.delete(livro.get());
		return livro.get().toDomain();
	}
	
}
