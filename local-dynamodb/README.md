# Local DynamoDB

This project is to show how to setup a local dynamoDB for development purposes.

The setup includes creating a named table when it doesn't exist so it is not necessary to create this table every time 
when dynamoDB starts.

`DynamoDBConfiguration.java`:
This class decides when to create an `AmazonDynamoDBClientBuilder` to the localhost (when `spring.profiles` is `local`)
or create a default one (when `spring.profiles` is `prod`).

When local is enabled:
- the localhost port number comes from the `dynamoDB.port` property in `application.yml` (default is `8000`).
- the region is set in code to `eu-central-1`

Table name is set to `sample-table-name` in `DynamoDBService.java`.

⚠️ To run the application you need to run a local DynamoDB which can be done in many ways:
https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DynamoDBLocal.html

In this project I used an executable `.jar` file. On Windows I created a `.cmd` file for quicker startup int the downloaded `.jar` directory:
```
java -Djava.library.path=./DynamoDBLocal_lib -jar DynamoDBLocal.jar -sharedDb -port 8000
pause >nul
```
⚠️ In this command the ports must be the same (`dynamoDB.port` - `-port 8000`)