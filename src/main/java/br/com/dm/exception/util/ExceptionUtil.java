package br.com.dm.exception.util;

import org.springframework.stereotype.Component;

import br.com.dm.model.ErroModel;

@Component
public class ExceptionUtil {

	public static ErroModel erro(String msg) {
		
		ErroModel erroModel = new ErroModel();
		
		erroModel.setDescricao(msg);
		
		return erroModel;
		
	}

}