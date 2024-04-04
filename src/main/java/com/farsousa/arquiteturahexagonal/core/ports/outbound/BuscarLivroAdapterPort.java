package com.farsousa.arquiteturahexagonal.core.ports.outbound;

import java.util.List;

import com.farsousa.arquiteturahexagonal.core.domains.Livro;

public interface BuscarLivroAdapterPort {
	List<Livro> execute(String autor, String titulo, Long id);
}
