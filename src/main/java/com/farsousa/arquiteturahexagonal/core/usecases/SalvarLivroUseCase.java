package com.farsousa.arquiteturahexagonal.core.usecases;

import com.farsousa.arquiteturahexagonal.core.domains.Livro;
import com.farsousa.arquiteturahexagonal.core.ports.inbound.SalvarLivroUseCasePort;
import com.farsousa.arquiteturahexagonal.core.ports.outbound.SalvarLivroAdapterPort;

public class SalvarLivroUseCase implements SalvarLivroUseCasePort  {
	
	private final SalvarLivroAdapterPort salvarLivroAdapterPort;
	
	public SalvarLivroUseCase(SalvarLivroAdapterPort salvarLivroAdapterPort) {
		this.salvarLivroAdapterPort = salvarLivroAdapterPort;
	}

	@Override
	public Livro execute(Livro livro) {
		return salvarLivroAdapterPort.execute(livro);
	}
	

}
