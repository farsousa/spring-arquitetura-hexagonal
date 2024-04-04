package com.farsousa.arquiteturahexagonal.core.ports.inbound;

import java.util.List;

import com.farsousa.arquiteturahexagonal.core.domains.Livro;

public interface BuscarLivroUseCasePort {
	
	List<Livro> execute(String autor, String titulo, Long id);

}
