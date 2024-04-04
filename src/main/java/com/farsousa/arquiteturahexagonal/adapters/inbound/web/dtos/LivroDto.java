package com.farsousa.arquiteturahexagonal.adapters.inbound.web.dtos;

import com.farsousa.arquiteturahexagonal.core.domains.Livro;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LivroDto {
	
	private Long id;
	private String autor;
	private String titulo;
	private String descricao;
	
	public static LivroDto fromEntity(Livro entity) {
		return LivroDto.builder()
				.autor(entity.getAutor())
				.descricao(entity.getDescricao())
				.id(entity.getId())
				.titulo(entity.getTitulo())
				.build();
	}

}
