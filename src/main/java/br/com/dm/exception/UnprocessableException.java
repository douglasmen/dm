package br.com.dm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.google.gson.Gson;

import br.com.dm.model.ErroModel;

@ResponseStatus(value=HttpStatus.UNPROCESSABLE_ENTITY)
public class UnprocessableException extends RuntimeException {
	
	private static final long serialVersionUID = 3802407053930005739L;

	public UnprocessableException(ErroModel erro) {
		super(new Gson().toJson(erro));
	}
	
}