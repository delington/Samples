# Swagger codegen

Sample project to show how `swagger-codegen-maven-plugin` works.

2 `.yaml` files are examples for code generation:
- `api.yaml`
- `petstore.yaml`

How to generate code:

`mvn clean compile`

⚠️ Make sure only one execution applies:
- `generate-spring-boot-server-api` for api generation in spring-boot
- `generate-retrofit2-client` for generate retrofit2 based http client