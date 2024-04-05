package com.farsousa.arquiteturahexagonal.infra.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.farsousa.arquiteturahexagonal.adapters.inbound.web.dtos.RespostaDto;

@RestControllerAdvice
public class ExceptionsHandler {

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<RespostaDto<?>> exceptionHandler(Exception e) {
		RespostaDto<?> resposta = new RespostaDto<>();
		resposta.setMensagem(e.getMessage());
		
		return ResponseEntity.status(400).body(resposta);
	}
	
	
}
