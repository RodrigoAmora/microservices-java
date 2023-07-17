# microservice-java
Projeto de exemplo de Micro-serviços em Java usando o Srping Cloud.

##

URL de Pagamentos: `http://{endereco-da-aplicacao}:8082/pagamentos-ms/{endpoint}`
URL de Pedidos: `http://{endereco-da-aplicacao}:8082/pedidos-ms/{endpoint}`

##

### Subir instâncias novas:

##
<b>Pagamentos</b><br>
No Linux e MacOS: `& "{caminho-da-aplicacao}/Pagamentos/mvnw.cmd" spring-boot:run -f "{caminho-da-aplicacao}/Pagamentos/pom.xml"`
No Windows: `& "{caminho-da-aplicacao}\Pagamentos\mvnw.cmd" spring-boot:run -f "{caminho-da-aplicacao}\Pagamentos\pom.xml"`

##
<b>Pedidos</b><br>
No Linux e MacOS: `& "{caminho-da-aplicacao}/Pedidos/mvnw.cmd" spring-boot:run -f "{caminho-da-aplicacao}/Pedidos/pom.xml"`
No Windows: `& "{caminho-da-aplicacao}\Pedidos\mvnw.cmd" spring-boot:run -f "{caminho-da-aplicacao}\Pedidos\pom.xml"`