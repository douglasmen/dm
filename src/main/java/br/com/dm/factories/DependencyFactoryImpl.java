package br.com.dm.factories;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DependencyFactoryImpl implements DependencyFactory {

	@Value(value = "${USUARIO_DB}")
	private String usuarioDb;

	@Value(value = "${SENHA_DB}")
	private String semjaDb;

	@Override
	public String getUsuarioDb() {
		return null;
	}

	@Override
	public String getSenhaDb() {
		return null;
	}
}