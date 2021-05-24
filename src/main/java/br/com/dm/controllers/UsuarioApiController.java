package br.com.dm.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.com.dm.controller.UsuariosApi;
import br.com.dm.model.UsuarioModel;

@RestController
public class UsuarioApiController implements UsuariosApi {

	@Override
	public ResponseEntity<UsuarioModel> buscarUsuario(String cpf) {
		return UsuariosApi.super.buscarUsuario(cpf);
	}

	@Override
	public ResponseEntity<Void> cadastrarUsuario(@Valid UsuarioModel dadosUsuarios) {
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