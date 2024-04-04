package com.farsousa.arquiteturahexagonal.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.farsousa.arquiteturahexagonal.adapters.outbound.persistense.BuscarLivroAdapter;
import com.farsousa.arquiteturahexagonal.adapters.outbound.persistense.SalvarLivroAdapter;
import com.farsousa.arquiteturahexagonal.adapters.outbound.persistense.repository.LivroRepository;
import com.farsousa.arquiteturahexagonal.core.ports.inbound.BuscarLivroUseCasePort;
import com.farsousa.arquiteturahexagonal.core.ports.inbound.SalvarLivroUseCasePort;
import com.farsousa.arquiteturahexagonal.core.ports.outbound.BuscarLivroAdapterPort;
import com.farsousa.arquiteturahexagonal.core.ports.outbound.SalvarLivroAdapterPort;
import com.farsousa.arquiteturahexagonal.core.usecases.BuscarLivroUseCase;
import com.farsousa.arquiteturahexagonal.core.usecases.SalvarLivroUseCase;

@Configuration
public class PortConfig {

	@Bean
	SalvarLivroUseCasePort salvarLivroUseCasePort(SalvarLivroAdapterPort salvarLivroAdapterPort) {
		return new SalvarLivroUseCase(salvarLivroAdapterPort);
	}
	
	@Bean
	SalvarLivroAdapterPort salvarLivroAdapterPort(LivroRepository livroRepository) {
		return new SalvarLivroAdapter(livroRepository);
	}
	
	@Bean
	BuscarLivroUseCasePort buscarLivroUseCasePort(BuscarLivroAdapterPort buscarLivroAdapterPort) {
		return new BuscarLivroUseCase(buscarLivroAdapterPort);
	}
	
	@Bean
	BuscarLivroAdapterPort buscarLivroAdapterPort(LivroRepository livroRepository) {
		return new BuscarLivroAdapter(livroRepository);
	}
	
	
	
}
