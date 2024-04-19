# microservices-java
Descrição:
----------
Projeto de exemplo de Microsserviços em Java usando o Srping Cloud.

##

Endpoints:
----------
URL de Pagamentos: `http://{endereco-da-aplicacao}:8082/pagamentos-ms/{endpoint}`
<br>
URL de Pedidos: `http://{endereco-da-aplicacao}:8082/pedidos-ms/{endpoint}`

Subir instâncias novas:
-----------------------
<b>Pagamentos</b><br>
No Linux e MacOS: `& "{caminho-da-aplicacao}/Pagamentos/mvnw.cmd" spring-boot:run -f "{caminho-da-aplicacao}/Pagamentos/pom.xml"`
<br><br>
No Windows: `& "{caminho-da-aplicacao}\Pagamentos\mvnw.cmd" spring-boot:run -f "{caminho-da-aplicacao}\Pagamentos\pom.xml"`


<b>Pedidos</b><br>
No Linux e MacOS: `& "{caminho-da-aplicacao}/Pedidos/mvnw.cmd" spring-boot:run -f "{caminho-da-aplicacao}/Pedidos/pom.xml"`
<br><br>
No Windows: `& "{caminho-da-aplicacao}\Pedidos\mvnw.cmd" spring-boot:run -f "{caminho-da-aplicacao}\Pedidos\pom.xml"`

Dependências:
-------------
O projeto o Java 17 e as seguintes dependências:
* Spring Boot
* Spring Cloud
* JPA
* ModelMapper

##
