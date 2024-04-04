package com.farsousa.arquiteturahexagonal.core.usecases;

import java.util.List;

import com.farsousa.arquiteturahexagonal.core.domains.Livro;
import com.farsousa.arquiteturahexagonal.core.ports.inbound.BuscarLivroUseCasePort;
import com.farsousa.arquiteturahexagonal.core.ports.outbound.BuscarLivroAdapterPort;

public class BuscarLivroUseCase implements BuscarLivroUseCasePort {
	
	private final BuscarLivroAdapterPort buscarLivroAdapterPort;
	
	public BuscarLivroUseCase(BuscarLivroAdapterPort buscarLivroPorAutorAdapterPort) {
		this.buscarLivroAdapterPort = buscarLivroPorAutorAdapterPort;
	}

	@Override
	public List<Livro> execute(String autor, String titulo, Long id) {	
		return buscarLivroAdapterPort.execute(autor, titulo, id);
	}

}
