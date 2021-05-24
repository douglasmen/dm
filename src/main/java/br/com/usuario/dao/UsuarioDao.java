package br.com.usuario.dao;

import org.springframework.stereotype.Component;

import br.com.dm.domain.Usuario;

@Component
public interface UsuarioDao {

	Usuario recuperarUsuario(String cpf);

	void cadastrarUsuario(Usuario usuario);

	void alterarUsuario(Usuario usuario);

	void deletarUsuario(String cpf);

}