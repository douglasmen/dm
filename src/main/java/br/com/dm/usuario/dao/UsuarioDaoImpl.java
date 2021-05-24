package br.com.dm.usuario.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDeleteExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;

import br.com.dm.domain.Usuario;

@Component
public class UsuarioDaoImpl implements UsuarioDao {

	private DynamoDBMapper dynamoDBMapper;

	@Autowired
	public UsuarioDaoImpl(DynamoDBMapper dynamoDBMapper) {
		this.dynamoDBMapper = dynamoDBMapper;
	}

	@Override
	public void cadastrarUsuario(Usuario usuario) {
		dynamoDBMapper.save(usuario);
	}

	@Override
	public Usuario recuperarUsuario(String cpf) {
		return dynamoDBMapper.load(Usuario.class, cpf);
	}

	@Override
	public void alterarUsuario(Usuario usuario) {
		DynamoDBSaveExpression saveExpression = new DynamoDBSaveExpression()
				.withExpected(montaExpectedAttributeValue(usuario.getCpf()));
		dynamoDBMapper.save(usuario, saveExpression);
	}

	@Override
	public void deletarUsuario(String cpf) {
		Map<String, ExpectedAttributeValue> expectedAttributeValueMap = new HashMap<>();
		expectedAttributeValueMap.put("cpf", new ExpectedAttributeValue(new AttributeValue().withS(cpf)));
		DynamoDBDeleteExpression deleteExpression = new DynamoDBDeleteExpression()
				.withExpected(montaExpectedAttributeValue(cpf));
		Usuario usuario = Usuario.builder().cpf(cpf).build();
		dynamoDBMapper.delete(usuario, deleteExpression);
	}

	private Map<String, ExpectedAttributeValue> montaExpectedAttributeValue(String valor) {
		Map<String, ExpectedAttributeValue> expectedAttributeValueMap = new HashMap<>();
		expectedAttributeValueMap.put("cpf", new ExpectedAttributeValue(new AttributeValue().withS(valor)));
		return expectedAttributeValueMap;
	}

}