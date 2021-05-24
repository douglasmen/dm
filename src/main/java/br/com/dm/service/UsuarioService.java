package br.com.dm.service;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dm.domain.Usuario;
import br.com.dm.exception.UnprocessableException;
import br.com.dm.exception.util.ExceptionUtil;
import br.com.dm.mapper.UsuarioMapper;
import br.com.dm.model.UsuarioModel;
import br.com.dm.repository.UsuarioRepository;

@Service
public class UsuarioService {

	private static final String ERRO_AO_BUSCAR_USUARIO = "erro ao buscar usuario";
	private static final String ERRO_AO_CADASTRAR_USUARIO = "erro ao cadastrar usuario";
	private UsuarioRepository usuarioRepository;
	private UsuarioMapper mapper = Mappers.getMapper(UsuarioMapper.class);
	
	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository=usuarioRepository;
	}
	
	public UsuarioModel recuperarUsuario(String cpf) {
		
		Usuario usuario = usuarioRepository.recuperarUsuario(cpf);
		
		if (usuario!=null) {
			return mapper.converterUsuario(usuario);
		}
		
		throw new UnprocessableException(ExceptionUtil.erro(ERRO_AO_BUSCAR_USUARIO));
		
	}
	
	public void cadastrarUsuario(UsuarioModel dadosUsuarios) {
		try {
			usuarioRepository.cadastrarUsuario(mapper.converterUsuario(dadosUsuarios));
		} catch (Exception e) {
			throw new UnprocessableException(ExceptionUtil.erro(ERRO_AO_CADASTRAR_USUARIO));
		}
	}

}