package br.com.dm.domain;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBTable(tableName = "usuario")
public class Usuario {

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