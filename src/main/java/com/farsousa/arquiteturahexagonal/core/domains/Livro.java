package com.farsousa.arquiteturahexagonal.core.domains;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Livro {
	
	private Long id;
	private String autor;
	private String titulo;
	private String descricao;

}
