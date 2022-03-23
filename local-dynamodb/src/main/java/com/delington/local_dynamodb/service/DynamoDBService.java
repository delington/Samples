package com.delington.local_dynamodb.service;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.model.*;
import com.amazonaws.services.dynamodbv2.util.TableUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Log4j2
@Service
public class DynamoDBService {

    private static final String TABLE_NAME = "sample-table-name";
    private static final String ATTRIBUTE_NAME = "Name";
    private static final long READ_CAPACITY_UNITS = 10L;
    private static final long WRITE_CAPACITY_UNITS = 10L;

    @Value("${dynamoDB.port}")
    private String port;

    private AmazonDynamoDB amazonDynamoDB;

    public DynamoDBService(AmazonDynamoDB amazonDynamoDB) {
        this.amazonDynamoDB = amazonDynamoDB;
    }

    @PostConstruct
    public void createTableOnStartUp() {
        createTable();
        listTables();
    }

    public void createTable() {
        CreateTableRequest createTableRequest = new CreateTableRequest()
                .withAttributeDefinitions(new AttributeDefinition(ATTRIBUTE_NAME, ScalarAttributeType.S))
                .withKeySchema(new KeySchemaElement(ATTRIBUTE_NAME, KeyType.HASH))
                .withProvisionedThroughput(new ProvisionedThroughput(READ_CAPACITY_UNITS, WRITE_CAPACITY_UNITS))
                .withTableName(TABLE_NAME);

        createTableIfNotExists(amazonDynamoDB, createTableRequest);
    }

    public void listTables() {
        final var listTableRequest = new ListTablesRequest().withLimit(10);
        log.info("Tables:" + amazonDynamoDB.listTables(listTableRequest).getTableNames());
    }

    public void deleteTable(String tableName) {
        checkIfTableNameExists(tableName);

        amazonDynamoDB.deleteTable(tableName);
        log.info("Table: " + tableName + " has deleted.");
    }

    private void checkIfTableNameExists(String tableName) {
        final var tableNameList = amazonDynamoDB.listTables().getTableNames();
        tableNameList.stream()
                .filter(name -> name == tableName)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Table with " + tableName + " does not exist!"));
    }

    private void createTableIfNotExists(AmazonDynamoDB dynamoDB, CreateTableRequest request) {
        final var isSuccess = TableUtils.createTableIfNotExists(dynamoDB, request);
        if(isSuccess) {
            log.info("Table: " + TABLE_NAME + " has created.");
        } else {
            log.info("Table: " + TABLE_NAME + " already exists!");
        }
    }
}
