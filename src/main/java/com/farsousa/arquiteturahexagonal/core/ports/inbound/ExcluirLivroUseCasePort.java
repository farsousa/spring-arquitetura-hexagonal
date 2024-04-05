package com.farsousa.arquiteturahexagonal.core.ports.inbound;

import com.farsousa.arquiteturahexagonal.core.domains.Livro;

public interface ExcluirLivroUseCasePort {
	
	public Livro execute(Long id);

}
