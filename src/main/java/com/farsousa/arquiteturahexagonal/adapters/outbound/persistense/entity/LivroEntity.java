package com.farsousa.arquiteturahexagonal.adapters.outbound.persistense.entity;

import com.farsousa.arquiteturahexagonal.core.domains.Livro;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tab_livro")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LivroEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tli_id")
	private Long id;
	@Column(name = "tli_autor")
	private String autor;
	@Column(name = "tli_titulo", unique = true)
	private String titulo;
	@Column(name = "tli_descricao")
	private String descricao;
	
	public static LivroEntity fromDomain(Livro livro) {
		return LivroEntity.builder()
				.autor(livro.getAutor())
				.descricao(livro.getDescricao())
				.titulo(livro.getTitulo())
				.id(livro.getId())
				.build();
	}
	
	public Livro toDomain() {
		return Livro.builder()
				.autor(autor)
				.descricao(descricao)
				.titulo(titulo)
				.id(id)
				.build();
	}

}
