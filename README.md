# SIMPLE PAYMENT AOT

Este projeto é uma representação de API de pagamento simples, com possibilidade de ser compilado de forma AOT através de GraalVM utilizando Spring Boot 3.

## Documentação

Documentação disponível no arquivo [api-docs.yaml](https://github.com/lucasbsimao/simple_payment_aot/blob/main/api-docs.yaml) ou através do endpoint: http://localhost:8080/swagger-ui/index.html

## Rodando o projeto

Pré requisitos:

- docker compose v2 ([Guia de instalação](https://docs.docker.com/compose/migrate/))

Comando para rodar o projeto:

```
docker compose up
```

## Rodando testes

Pré requisitos:

- java 17 ([Sdkman](https://sdkman.io/install))

Comando para rodar testes:

```
./gradlew test
```

## Build AOT

Builds AOT possuem a vantagem de compilar a aplicação diretamente em código nativo ao invés de compilado para bytecode e interpretado posteriormente, adquirindo assim vantagens de performance e de otimização de memória.

Para dar build deste projeto nesta modalidade há duas possibilidades:

### Gerar imagem docker

Pré requisitos:
- Java 17

Comando:

```
./gradlew bootBuildImage
docker run -rm app:1.0.0
```

### Gerar um executável nativo

Pré requisitos:
- GraalVM CE 17

Comando:

```
./gradlew nativeCompile
/app/build/native/nativeCompile/app
```



