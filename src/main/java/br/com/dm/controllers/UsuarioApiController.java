package br.com.dm.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.dm.controller.UsuariosApi;
import br.com.dm.exception.UnprocessableException;
import br.com.dm.model.UsuarioModel;
import br.com.dm.service.UsuarioService;

@RestController
public class UsuarioApiController implements UsuariosApi {

	@Autowired
	private UsuarioService usuarioService;
	
	public UsuarioApiController(UsuarioService usuarioService) {
		this.usuarioService=usuarioService;
	}
	
	@Override
	public ResponseEntity<UsuarioModel> buscarUsuario(@PathVariable("cpf") String cpf) throws UnprocessableException {
		return new ResponseEntity<>(usuarioService.recuperarUsuario(cpf), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Void> cadastrarUsuario(@RequestBody UsuarioModel dadosUsuarios) {
		usuarioService.cadastrarUsuario(dadosUsuarios);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Void> deletarUsuario(String cpf) {
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Void> alterarUsuario(@Valid UsuarioModel dadosUsuarios) {
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}