package com.farsousa.arquiteturahexagonal.core.ports.inbound;

import com.farsousa.arquiteturahexagonal.core.domains.Livro;

public interface SalvarLivroUseCasePort {
	
	public Livro execute(Livro livro);

}
