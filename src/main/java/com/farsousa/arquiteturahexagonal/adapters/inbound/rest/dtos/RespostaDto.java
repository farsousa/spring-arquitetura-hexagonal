package com.farsousa.arquiteturahexagonal.adapters.inbound.rest.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class RespostaDto<T> {
	
	private String mensagem;
	private T dado;
	private List<T> lista;

}
