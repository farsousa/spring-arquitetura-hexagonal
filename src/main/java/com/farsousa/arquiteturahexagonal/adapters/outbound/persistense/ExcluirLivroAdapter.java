package com.farsousa.arquiteturahexagonal.adapters.outbound.persistense;

import java.util.Optional;

import com.farsousa.arquiteturahexagonal.adapters.outbound.persistense.entity.LivroEntity;
import com.farsousa.arquiteturahexagonal.adapters.outbound.persistense.repository.LivroRepository;
import com.farsousa.arquiteturahexagonal.core.domains.Livro;
import com.farsousa.arquiteturahexagonal.core.ports.outbound.ExcluirLivroAdapterPort;
import com.farsousa.arquiteturahexagonal.infra.exceptions.NaoEncontradoException;

public class ExcluirLivroAdapter implements ExcluirLivroAdapterPort {

	private LivroRepository livroRepository;
	
	public ExcluirLivroAdapter(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}

	public Livro execute(Long id) {
		Optional<LivroEntity> livro = livroRepository.findById(id);
		
		if(livro.isEmpty()) throw new NaoEncontradoException("Livro não encontrado!");
		
		livroRepository.delete(livro.get());
		return livro.get().toDomain();
	}
	
}
