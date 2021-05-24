package br.com.dm.domain;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@DynamoDBTable(tableName = "usuario")
public class Usuario {

	@DynamoDBHashKey
	private String id;

	@DynamoDBAttribute
	private String nome;

	@DynamoDBAttribute
	private String email;

	@DynamoDBAttribute
	private String nomeArquivo;

	@DynamoDBAttribute
	private String nomeArquivoOriginal;

	@DynamoDBHashKey(attributeName = "cpf")
	private String cpf;

}