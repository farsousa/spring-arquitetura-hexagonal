package com.farsousa.arquiteturahexagonal.core.ports.outbound;

import com.farsousa.arquiteturahexagonal.core.domains.Livro;

public interface SalvarLivroPersistensePort {
	
	public Livro execute(Livro livro);

}
