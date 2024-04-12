package com.farsousa.arquiteturahexagonal.adapters.inbound.rest.forms;

import com.farsousa.arquiteturahexagonal.core.domains.Livro;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LivroForm {
	
	@NotBlank(message = "O campo autor é obrigatório!")
	private String autor;
	@NotBlank(message = "O campo titulo é obrigatório!")
	private String titulo;
	@NotBlank(message = "O campo descrição é obrigatório!")
	private String descricao;
	
	public Livro toEntity() {
		Livro livro = new Livro();
		livro.setAutor(autor);
		livro.setDescricao(descricao);
		livro.setTitulo(titulo);
		
		return livro;
	}

}
