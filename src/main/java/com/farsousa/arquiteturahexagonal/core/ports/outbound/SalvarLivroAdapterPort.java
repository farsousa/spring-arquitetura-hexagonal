package com.farsousa.arquiteturahexagonal.core.ports.outbound;

import com.farsousa.arquiteturahexagonal.core.domains.Livro;

public interface SalvarLivroAdapterPort {
	
	public Livro execute(Livro livro);

}
