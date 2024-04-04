package com.farsousa.arquiteturahexagonal.adapters.inbound.web;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
import com.farsousa.arquiteturahexagonal.core.ports.inbound.SalvarLivroUseCasePort;

@RestController
@RequestMapping("/livro")
public class LivroController {
	
	private final SalvarLivroUseCasePort salvarLivroUseCasePort;
	private final BuscarLivroUseCasePort buscarLivroUseCasePort;
	
	LivroController(SalvarLivroUseCasePort salvarLivroUseCasePort, BuscarLivroUseCasePort buscarLivroPorAutorUseCasePort) {
		this.salvarLivroUseCasePort = salvarLivroUseCasePort;
		this.buscarLivroUseCasePort = buscarLivroPorAutorUseCasePort;
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<RespostaDto<LivroDto>> cadastrar(
		@RequestBody LivroForm livroASalvar
	) {
		Livro livroSalvo = salvarLivroUseCasePort.execute(livroASalvar.toEntity());
		
		RespostaDto<LivroDto> resposta = new RespostaDto<>();
		resposta.setDado(LivroDto.fromEntity(livroSalvo));
		
		return ResponseEntity.status(202).body(resposta);
	}
	
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

}
