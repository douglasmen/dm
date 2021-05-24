package br.com.dm.factories;

import org.springframework.stereotype.Component;

@Component
public interface DependencyFactory {

	String getUsuarioDb();

	String getSenhaDb();

}