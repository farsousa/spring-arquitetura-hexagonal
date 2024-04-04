package com.farsousa.arquiteturahexagonal.adapters.outbound.persistense;

import com.farsousa.arquiteturahexagonal.adapters.outbound.persistense.entity.LivroEntity;
import com.farsousa.arquiteturahexagonal.adapters.outbound.persistense.repository.LivroRepository;
import com.farsousa.arquiteturahexagonal.core.domains.Livro;
import com.farsousa.arquiteturahexagonal.core.ports.outbound.SalvarLivroAdapterPort;

public class SalvarLivroAdapter implements SalvarLivroAdapterPort {
	
	private final LivroRepository repository;
	
	public SalvarLivroAdapter(LivroRepository repository) {
		this.repository = repository;
	}

	@Override
	public Livro execute(Livro livro) {
		return repository.save(LivroEntity.fromDomain(livro)).toDomain();
	}

}
