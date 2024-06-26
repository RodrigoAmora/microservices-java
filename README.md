# microservices-java
Descrição:
----------
Projeto de exemplo de Microsserviços em Java usando o Srping Cloud e o RabbitMQ para Mensageria.

Endpoints:
----------
URL de Pagamentos: `http://<URL_DO_PORJETO>:8082/pagamentos-ms/{endpoint}` <br>
URL de Pedidos: `http://<URL_DO_PORJETO>:8082/pedidos-ms/{endpoint}`
<br><br>
Na pasta `Postman` contém a collection para os endpoints via Postman.

Subir instâncias novas:
-----------------------
Para subir novas instâncias, execute o comando no diretório raiz de Pagamentos e Pedidos:
```shell script
mvn spring-boot:run -f pom.xml
```

Dependências:
-------------
O projeto o Java 17 e as seguintes dependências:
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
O projeto usa o MySQL para ambiente de desenvolvimento e o H2 para o ambiente de teste.<br>
Para acessar o painel do H2: `<URL_DO_PORJETO>/h2-console`

Gerando o arquivo .jar:
-----------------------
Para gerar o arquivo <b>.jar</b>, execute o comando via terminal no diretório raiz de cada um dos projetos:
```shell script
mvn clean install
```

Docker:
-------
Após gerar o .jar de cada projeto, gerar a imagem de cada um dos projetos:<br>
<b>Server:</b>
```shell script
docker build --tag=server:latest .
```

<b>Gateway:</b>
```shell script
docker build --tag=gateway:latest .
```

<b>Pagamenstos:</b>
```shell script
docker build --tag=pagamentos:latest .
```

<b>Pedidos:</b>
```shell script
docker build --tag=pedidos:latest .
```

RabbitMQ:
---------
<!--
Execute o comando para rodar RabbitMQ via Docker:
```shell script
docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3.10-management
```
-->
Para acessar o RabbitMQ, acesse o endereço: `http://<URL_DO_PORJETO>:15672/`
<br>
<b>Usuário:</b> Guest <br>
<b>Senha:</b> Guest

Rodando o Projeto:
------------------
A orden certa de rodar o projeto é:
* 1º - Server
* 2º - Gateway
* 3º - Pedidos
* 4º - Pagamentos

Para rodar cada projeto execute o comando no diretório raiz de cada um dos projetos:
```shell script
mvn spring-boot:run
```

Autor:
------
<b>Rodrigo Amora</b>

LinkedIn: https://linkedin.com/in/rodrigoamora <br>
E-mail: rodrigo.amora.freitas@gmail.com
