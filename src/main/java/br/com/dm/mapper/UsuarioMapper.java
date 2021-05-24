package br.com.dm.mapper;

import org.mapstruct.Mapper;

import br.com.dm.domain.Usuario;
import br.com.dm.model.UsuarioModel;

@Mapper
public interface UsuarioMapper {
	
	UsuarioModel converterUsuario(Usuario usuario);
	
	Usuario converterUsuario(UsuarioModel usuario);
	
}