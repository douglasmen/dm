package br.com.dm.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.dm.domain.Usuario;
import br.com.dm.usuario.dao.UsuarioDao;

@Repository
public class UsuarioRepository {

	private UsuarioDao dao;
	
	@Autowired
	public UsuarioRepository(UsuarioDao dao) {
		this.dao=dao;
	}
	
	public Usuario recuperarUsuario(String cpf) {
		return dao.recuperarUsuario(cpf);
	}
	
	public void cadastrarUsuario(Usuario dadosUsuario) {
		dao.cadastrarUsuario(dadosUsuario);
	}

}