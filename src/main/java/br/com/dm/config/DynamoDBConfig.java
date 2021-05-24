package br.com.dm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;

import br.com.dm.factories.DependencyFactory;

@Configuration
public class DynamoDBConfig {

	private DependencyFactory dependencyFactory;

	@Autowired
	public DynamoDBConfig(DependencyFactory dependencyFactory) {
		this.dependencyFactory = dependencyFactory;
	}

	@Bean
	public DynamoDBMapper dynamoDBMapper() {
		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
				.withCredentials(new AWSStaticCredentialsProvider(
						new BasicAWSCredentials("AKIAXTSGOD3T2AIEV5XL", "6gKYNibwup1h6vi2hC5yRL+PrTcf3+RvSB/6LKsU")))
				.withRegion(Regions.SA_EAST_1).build();
		return new DynamoDBMapper(client, DynamoDBMapperConfig.DEFAULT);
	}

}