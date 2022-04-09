# Swagger codegen

Sample project fow showing swagger-codegen-maven-plugin working.

2 `.yaml` files are examples for code generation:
- `api.yaml`
- `petstore.yaml`

How to generate code:

`mvn clean compile`

Make sure you set the correct execution:
- `generate-spring-boot-server-api` for api generation in spring-boot
- `generate-retrofit2-client` for generate retrofit2 based http client