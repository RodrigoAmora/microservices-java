# Define a imagem base
FROM openjdk:17-oracle

LABEL maintainer="rodrigo.amora.freitas@gmail.com"
LABEL version="1.0.7"
LABEL name="Rodrigo Amora"

# Define as variáveis AAP_NAME e VERSION
ENV APP_NAME=Pedidos
ENV VERSION=0.0.1-SNAPSHOT

# Copia o arquivo JAR do seu projeto para dentro do container
COPY ./target/${APP_NAME}-${VERSION}.jar  /app/${APP_NAME}.jar

# Define o diretório de trabalho
WORKDIR /app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

RUN chmod +x ./mvnw
# Faça o download das dependencias do pom.xml
RUN ./mvnw dependency:go-offline -B

COPY src src

RUN ./mvnw package -DskipTests
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)



# Define o comando de inicialização do seu projeto
CMD java -jar ${APP_NAME}.jar

# Expõe a porta do seu projeto
#EXPOSE 80 8080

