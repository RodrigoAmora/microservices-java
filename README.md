# microservices-java
Descrição:
----------
Projeto de exemplo de Microsserviços em Java usando o Srping Cloud.

Endpoints:
----------
URL de Pagamentos: `http://{endereco-da-aplicacao}:8082/pagamentos-ms/{endpoint}`
<br>
URL de Pedidos: `http://{endereco-da-aplicacao}:8082/pedidos-ms/{endpoint}`

Subir instâncias novas:
-----------------------
<b>Pagamentos</b><br>
```shell script
& "{caminho-da-aplicacao}/Pagamentos/mvnw.cmd" spring-boot:run -f "{caminho-da-aplicacao}/Pagamentos/pom.xml"
```
<br>

<b>Pedidos</b><br>
```shell script
& "{caminho-da-aplicacao}/Pedidos/mvnw.cmd" spring-boot:run -f "{caminho-da-aplicacao}/Pedidos/pom.xml"
```

Dependências:
-------------
O projeto o Java 17, Spring Boot 3.1.1 e as seguintes dependências:
* Spring Cloud
* Spring Data JPA
* ModelMapper
* MySql

Rodando o Projeto:
------------------
A orden certa de rodar o projeto é:
1º - Server
2º - Gateway
3º - Pedidos
4º - Pagamentos

Para rodar cada projeto execute o comando no diretório raiz de cada um dos projetos:
```shell script
mvn spring-boot:run
```
