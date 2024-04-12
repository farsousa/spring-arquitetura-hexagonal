package com.farsousa.arquiteturahexagonal.core.ports.outbound;

import com.farsousa.arquiteturahexagonal.core.domains.Livro;

public interface ExcluirLivroPersistensePort {
	
	public Livro execute(Long id);

}
