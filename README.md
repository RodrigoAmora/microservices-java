# microservices-java
Descrição:
----------
Projeto de exemplo de Microsserviços em Java usando o Srping Cloud e o RabbitMQ para Mensageria.

Endpoints:
----------
<b>URL de Pagamentos:</b>
```shell script
http://localhost:8082/pagamentos-ms/{endpoint}
```

##

<b>URL de Pedidos:</b>
```shell script
http://localhost:8082/pedidos-ms/{endpoint}
```

##
Na pasta `<b>Postman</b>` contém a collection para usar os endpoints via Postman.

Dependências:
-------------
O projeto usa o Java 17 e as seguintes dependências:
* Spring Boot 3.1.1
* Spring Cloud
* Spring Data JPA
* Spring AMQP
* ModelMapper
* MySql
* H2
* Devtools
* jUnit
* Rest-Assured

Banco de dados:
---------------
O projeto usa o MySQL para ambiente de desenvolvimento e produção e o H2 para o ambiente de teste.<br><br>
Para acessar o painel do H2:
```shell script
http://localhost:8082/h2-console
```

Gerando o arquivo .jar:
-----------------------
Para gerar o arquivo <b>.jar</b>, execute o comando via terminal no diretório raiz de cada um dos projetos:
```shell script
mvn clean install
```

Rodando o Projeto:
------------------
A orden certa de rodar o projeto localmente é:
* 1º - Server
* 2º - Gateway
* 3º - Pedidos
* 4º - Pagamentos

Para rodar cada projeto localmente, execute o comando no diretório raiz de cada um dos projetos:
```shell script
mvn spring-boot:run
```
Subindo instâncias novas:
-------------------------
Para subir novas instâncias, execute o comando no diretório raiz de Pagamentos e Pedidos:
```shell script
mvn spring-boot:run -f pom.xml
```

RabbitMQ:
---------
<!--
Execute o comando para rodar RabbitMQ via Docker:
```shell script
docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3.10-management
```
-->
Para acessar o RabbitMQ, acesse o endereço:
```shell script
http://localhost:15672/
```
<br>
<b>Usuário:</b> Guest <br>
<b>Senha:</b> Guest

Docker:
-------
Para rodar o projeto em um container Docker, primeiro deve-se gerar o .jar de cada projeto.<br>
Após isso, deve-se gerar o build e subir dos container do Docker:<br>
```shell script
docker-compose build

docker-compose up -d
```

Autor:
------
<b>Rodrigo Amora</b>

LinkedIn: https://linkedin.com/in/rodrigoamora <br>
E-mail: rodrigo.amora.freitas@gmail.com
