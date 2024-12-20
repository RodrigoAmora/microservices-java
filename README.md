# microservices-java
Descrição:
----------
Projeto de exemplo de Microsserviços em Java usando o Srping Cloud e o RabbitMQ para Mensageria.

Dependências:
-------------
O projeto usa o Java 17 e as seguintes dependências:
* Spring Boot 3.1.1
* Spring Cloud
* Spring Data JPA
* Spring AMQP
* Actuator
* Micrometer
* ModelMapper
* Devtools
* Swagger
* OpenAPI
* MySql

Endpoints:
----------
A documentação dos endpoints pode ser vista através do Swagger e do Redoc.<br>

<b>Documentação dos endpoints de Pagamento via Swagger:</b>
```shell script
http://localhost:8082/pagamentos-ms/swagger-ui.html
```

<b>Documentação dos endpoints de Pagamento via Redoc:</b>
```shell script
http://localhost:8082/pagamentos-ms/redoc.html
```

##

<b>Documentação dos endpoints de Pedido via Swagger:</b>
```shell script
http://localhost:8083/pedidos-ms/swagger-ui.html
```

<b>Documentação dos endpoints de Pedido via Redoc:</b>
```shell script
http://localhost:8083/pedidos-ms/redoc.html
```

##
Na pasta <b>`Postman`</b> contém a collection para usar os endpoints via Postman.

Banco de dados:
---------------
O projeto usa o banco de dados MySQL.

Gerando o arquivo .jar:
-----------------------
Para gerar o arquivo <b>.jar</b>, execute o comando via terminal no diretório raiz de cada um dos projetos:
```shell script
mvn clean install -P{profile} -DskipTests
```

Rodando o projeto:
------------------
A orden correta de rodar o projeto localmente é:
* 1º - Server
* 2º - Gateway
* 3º - Pedidos
* 4º - Pagamentos
* 5º - Avaliação

Para rodar cada projeto localmente, execute o comando no diretório raiz de cada um dos projetos:
```shell script
mvn spring-boot:run
```
Subindo instâncias novas:
-------------------------
Para subir novas instâncias, execute o comando no diretório raiz de <b>`Pagamentos e Pedidos`</b>:
```shell script
mvn spring-boot:run -f pom.xml
```

RabbitMQ:
---------
Acesse o RabbitMQ através do endereço:
```shell script
http://localhost:15672/
```

<b>Usuário:</b> Guest <br>
<b>Senha:</b> Guest

##
Para habilitar os pluginsRabbitMQ Shovel e RabbitMQ Shovel Management, execute o comando:
```shell script
rabbitmq-plugins enable rabbitmq_shovel rabbitmq_shovel_management
```

##
Caso queria rodar o projeto loclamente e rodar o RabbitMQ via Docker, execeto o comando:
```shell script
docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3.10-management
```

Prometheus:
-----------
Acesse o Prometheus através do endereço:
```shell script
http://localhost:9090/
```

##
Caso queria rodar o projeto loclamente e rodar o Prometheus via Docker, execeto o comando:
```shell script
docker run --name prometheus -d -p 127.0.0.1:9090:9090 prom/prometheus
```

Grafana:
--------
Acesse o Grafana através do endereço:
```shell script
http://localhost:3000/
```

<b>Username:</b> admin <br>
<b>Password:</b> admin

##
Caso queria rodar o projeto loclamente e rodar o Grafana via Docker, execeto o comando:
```shell script
docker run -d --name=grafana -p 3000:3000 grafana/grafana
```

Docker:
-------
Para rodar o projeto em um container Docker, primeiro deve-se gerar o .jar de cada um dos projetos.<br>
Após isso, deve-se gerar o build das imagens e subir os containers do Docker.<br><br>
<b>Fazendo o build das imagens do Docker:</b>
```shell script
docker-compose build
```

<b>Subindo os containers do Docker:</b>
```shell script
docker-compose up -d
```

##
Para automatizar esse processo, basta executar o Shellscript <b>`docker_build_and_run.sh`</b>:
```shell script
./docker_build_and_run.sh
```

Autor:
------
<b>Rodrigo Amora</b>

LinkedIn: https://linkedin.com/in/rodrigoamora <br>
E-mail: rodrigo.amora.freitas@gmail.com
