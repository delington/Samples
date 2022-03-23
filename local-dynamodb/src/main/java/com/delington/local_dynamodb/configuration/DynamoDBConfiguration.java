package com.delington.local_dynamodb.configuration;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Log4j2
@Configuration
public class DynamoDBConfiguration {

    private static final String REGION = "eu-central-1";
    private static final String LOCALHOST_PREFIX = "http://localhost";

    @Value("${dynamoDB.port}")
    private String port;

    @Bean
    @ConditionalOnProperty(prefix = "spring.profiles", name = "active", havingValue = "local")
    public AmazonDynamoDB amazonLocalDynamoDB() {
        final var endpointConfiguration = new AwsClientBuilder
                .EndpointConfiguration(LOCALHOST_PREFIX + ":" + port, REGION);

        return AmazonDynamoDBClientBuilder
                .standard()
                .withEndpointConfiguration(endpointConfiguration)
                .build();
    }

    @Bean
    @ConditionalOnProperty(prefix = "spring.profiles", name = "active", havingValue = "prod")
    public AmazonDynamoDB amazonDynamoDB() {
        return AmazonDynamoDBClientBuilder.defaultClient();
    }
}
