package com.farsousa.arquiteturahexagonal.core.usecases;

import com.farsousa.arquiteturahexagonal.core.domains.Livro;
import com.farsousa.arquiteturahexagonal.core.ports.inbound.ExcluirLivroUseCasePort;
import com.farsousa.arquiteturahexagonal.core.ports.outbound.ExcluirLivroAdapterPort;

public class ExcluirLivroUseCase implements ExcluirLivroUseCasePort {
	
	private final ExcluirLivroAdapterPort excluirLivroAdapterPort;
	
	public ExcluirLivroUseCase(ExcluirLivroAdapterPort excluirLivroAdapterPort) {
		this.excluirLivroAdapterPort = excluirLivroAdapterPort;
	}

	@Override
	public Livro execute(Long id) {
		return excluirLivroAdapterPort.execute(id);
	}

}
