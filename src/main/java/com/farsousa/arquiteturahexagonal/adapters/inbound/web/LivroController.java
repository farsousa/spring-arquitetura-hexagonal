package com.farsousa.arquiteturahexagonal.adapters.inbound.web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.farsousa.arquiteturahexagonal.adapters.inbound.web.dtos.LivroDto;
import com.farsousa.arquiteturahexagonal.adapters.inbound.web.dtos.RespostaDto;
import com.farsousa.arquiteturahexagonal.adapters.inbound.web.forms.LivroForm;
import com.farsousa.arquiteturahexagonal.core.domains.Livro;
import com.farsousa.arquiteturahexagonal.core.ports.inbound.BuscarLivroUseCasePort;
import com.farsousa.arquiteturahexagonal.core.ports.inbound.ExcluirLivroUseCasePort;
import com.farsousa.arquiteturahexagonal.core.ports.inbound.SalvarLivroUseCasePort;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@OpenAPIDefinition(info = @Info(title = "API Arquitetura Hexagonal", version = "1.0.0", description = "API para ser referência de estudo no assunto arquitetura hexagonal."))
@Tag(name = "Livro")
@RestController
@RequestMapping("/livro")
public class LivroController {
	
	private final SalvarLivroUseCasePort salvarLivroUseCasePort;
	private final BuscarLivroUseCasePort buscarLivroUseCasePort;
	private final ExcluirLivroUseCasePort excluirLivroPorIdUseCasePort;
	
	LivroController(SalvarLivroUseCasePort salvarLivroUseCasePort, BuscarLivroUseCasePort buscarLivroPorAutorUseCasePort, ExcluirLivroUseCasePort excluirLivroPorIdUseCasePort) {
		this.salvarLivroUseCasePort = salvarLivroUseCasePort;
		this.buscarLivroUseCasePort = buscarLivroPorAutorUseCasePort;
		this.excluirLivroPorIdUseCasePort = excluirLivroPorIdUseCasePort;
	}
	
	@Operation(summary = "Salvar um livro")
	@ApiResponses(value = { 
		@ApiResponse(responseCode = "202", description = "Livro criado com sucesso", content = { 
			@Content(mediaType = "application/json", schema = @Schema(implementation = Object.class), examples = @ExampleObject("{\"mensagem\": \"Livro salvo com sucesso!\",\"dado\":{\"id\":1,\"autor\":\"Gustavo\",\"titulo\":\"Como ter 3 milhões em uma semana\",\"descricao\":\"Uma dica emocionante\"}}"))
		}), 
		@ApiResponse(responseCode = "400", description = "Erro ao salvar o livro", content = { 
			@Content(mediaType = "application/json", schema = @Schema(implementation = Object.class), examples = @ExampleObject("{\"mensagem\": \"Descrição do erro aqui!\"}"))
		})
	})
	@PostMapping("/salvar")
	public ResponseEntity<RespostaDto<LivroDto>> salvar(
		@Schema(example = "{\"autor\":\"Gustavo\",\"titulo\":\"Como ter 3 milhões em uma semana\",\"descricao\":\"Uma dica emocionante\"}") @RequestBody LivroForm livroASalvar
	) {
		Livro livroSalvo = salvarLivroUseCasePort.execute(livroASalvar.toEntity());
		
		RespostaDto<LivroDto> resposta = new RespostaDto<>();
		resposta.setDado(LivroDto.fromEntity(livroSalvo));
		resposta.setMensagem("Livro salvo com sucesso!");
		
		return ResponseEntity.status(202).body(resposta);
	}
	
	@Operation(summary = "Listar livros por id e/ou titulo e/ou autor")
	@ApiResponses(value = { 
		@ApiResponse(responseCode = "200", description = "Sucesso ao listar livros", content = { 
			@Content(mediaType = "application/json", schema = @Schema(implementation = Object.class), examples = @ExampleObject("{\"lista\":[{\"id\":1,\"autor\":\"Gustavo\",\"titulo\":\"Como ter 3 milhões em uma semana\",\"descricao\":\"Uma dica emocionante\"},{\"id\":2,\"autor\":\"Anderson\",\"titulo\":\"A culpa é da Lua\",\"descricao\":\"Um romance emocionante\"}]}"))
		}), 
		@ApiResponse(responseCode = "400", description = "Erro ao listar livros", content = { 
			@Content(mediaType = "application/json", schema = @Schema(implementation = Object.class), examples = @ExampleObject("{\"mensagem\": \"Descrição do erro aqui!\"}"))
		})
	})
	@GetMapping("/buscar")
	public ResponseEntity<RespostaDto<LivroDto>> buscar(
		@RequestParam(required = false) String titulo, 
		@RequestParam(required = false) String autor, 
		@RequestParam(required = false) Long id
	) {
		List<Livro> livrosEncontrados = buscarLivroUseCasePort.execute(autor, titulo, id);
		
		RespostaDto<LivroDto> resposta = new RespostaDto<>();
		resposta.setLista(livrosEncontrados.stream().map(LivroDto::fromEntity).toList());
		
		return ResponseEntity.status(200).body(resposta);
	}
	
	@Operation(summary = "Excluir livro usando o id")
	@ApiResponses(value = { 
		@ApiResponse(responseCode = "200", description = "Sucesso ao excluir livro", content = { 
			@Content(mediaType = "application/json", schema = @Schema(implementation = Object.class), examples = @ExampleObject("{\"mensagem\": \"Livro excluído com sucesso!\",\"dado\":{\"id\":1,\"autor\":\"Gustavo\",\"titulo\":\"Como ter 3 milhões em uma semana\",\"descricao\":\"Uma dica emocionante\"}}"))
		}), 
		@ApiResponse(responseCode = "404", description = "Livro não encontrado", content = { 
			@Content(mediaType = "application/json", schema = @Schema(implementation = Object.class), examples = @ExampleObject("{\"mensagem\": \"Livro não encontrado!\"}"))
		}),
		@ApiResponse(responseCode = "400", description = "Erro ao excluir livro", content = { 
			@Content(mediaType = "application/json", schema = @Schema(implementation = Object.class), examples = @ExampleObject("{\"mensagem\": \"Descrição do erro aqui!\"}"))
		})
	})
	@DeleteMapping("/{id}")
	public ResponseEntity<RespostaDto<LivroDto>> excluir(
		@PathVariable Long id
	) {
		Livro livroExcluido = excluirLivroPorIdUseCasePort.execute(id);
		
		RespostaDto<LivroDto> resposta = new RespostaDto<>();
		resposta.setDado(LivroDto.fromEntity(livroExcluido));
		resposta.setMensagem("Livro excluído com sucesso!");
		
		return ResponseEntity.status(200).body(resposta);
	}

}
