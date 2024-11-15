#!/bin/bash

#############################################
### Shellscript to up Docker's containers ###
#############################################


### Server ###
echo -e "\033[01;32m##################\033[01;32m"
echo -e "\033[01;32m##################\033[01;32m"
echo -e "\033[01;32m##### Server #####\033[01;32m"
echo -e "\033[01;32m##################\033[01;32m"
echo -e "\033[01;32m##################\033[01;32m"
echo -e "\n"

docker_image=$(docker images server)

if [[ ! -z "${docker_image}" ]]; then
	echo -e "\033[01;32mApagando a imagem Server....\033[01;32m"
	echo -e "\n"
	docker rmi -f server
	echo -e "\n"
fi

cd Server/
rm -rf target/
mvn clean install -DskipTests
###############

cd ../
echo -e "\n\n"

### Gateway ###
echo -e "\033[01;32m###################\033[01;32m"
echo -e "\033[01;32m###################\033[01;32m"
echo -e "\033[01;32m##### Gateway #####\033[01;32m"
echo -e "\033[01;32m###################\033[01;32m"
echo -e "\033[01;32m###################\033[01;32m"
echo -e "\n"

docker_image=$(docker images gateway)

if [[ ! -z "${docker_image}" ]]; then
	echo -e "\033[01;32mApagando a imagem Gateway....\033[01;32m"
	echo -e "\n"
	docker rmi -f gateway
	echo -e "\n"
fi

cd Gateway/
rm -rf target/
mvn clean install -DskipTests
###############

cd ../
echo -e "\n\n"

### Pagamentos ###
echo -e "\033[01;32m######################\033[01;32m"
echo -e "\033[01;32m######################\033[01;32m"
echo -e "\033[01;32m##### Pagamentos #####\033[01;32m"
echo -e "\033[01;32m######################\033[01;32m"
echo -e "\033[01;32m######################\033[01;32m"
echo -e "\n"

docker_image=$(docker images pagamentos)

if [[ ! -z "${docker_image}" ]]; then
	echo -e "\033[01;32mApagando a imagem Pagamentos....\033[01;32m"
	echo -e "\n"
	docker rmi -f pagamentos
	echo -e "\n"
fi

cd Pagamentos/
rm -rf target/
mvn clean install -Pdocker -DskipTests
###############

cd ../
echo -e "\n\n"

### Pedidos ###
echo -e "\033[01;32m###################\033[01;32m"
echo -e "\033[01;32m###################\033[01;32m"
echo -e "\033[01;32m##### Pedidos #####\033[01;32m"
echo -e "\033[01;32m###################\033[01;32m"
echo -e "\033[01;32m###################\033[01;32m"
echo -e "\n"

docker_image=$(docker images pedidos)

if [[ ! -z "${docker_image}" ]]; then
	echo -e "\033[01;32mApagando a imagem Pedidos....\033[01;32m"
	echo -e "\n"
	docker rmi -f pedidos
	echo -e "\n"
fi

cd Pedidos/
rm -rf target/
mvn clean install -Pdocker -DskipTests
###############

cd ../
echo -e "\n\n"

### Avaliacao ###
echo -e "\033[01;32m#####################\033[01;32m"
echo -e "\033[01;32m#####################\033[01;32m"
echo -e "\033[01;32m##### Avaliacao #####\033[01;32m"
echo -e "\033[01;32m#####################\033[01;32m"
echo -e "\033[01;32m#####################\033[01;32m"
echo -e "\n"

docker_image=$(docker images avaliacao)

if [[ ! -z "${docker_image}" ]]; then
	echo -e "\033[01;32mApagando a imagem Avaliacao....\033[01;32m"
	echo -e "\n"
	docker rmi -f avaliacao
	echo -e "\n"
fi

cd Avaliacao/
rm -rf target/
mvn clean install -DskipTests
###############

cd ../
echo -e "\n\n"

### Docker ###
echo -e "\033[01;32m##################\033[01;32m"
echo -e "\033[01;32m##################\033[01;32m"
echo -e "\033[01;32m##### Docker #####\033[01;32m"
echo -e "\033[01;32m##################\033[01;32m"
echo -e "\033[01;32m##################\033[01;32m"

echo -e "\n\n"
echo -e "\033[01;32m#######################################\033[01;32m"
echo -e "\033[01;32m### Fazendo o build das imagens.... ###\033[01;32m"
echo -e "\033[01;32m#######################################\033[01;32m"
echo -e "\n"

sudo docker-compose build

echo -e "\n\n"
echo -e "\033[01;32m#############################\033[01;32m"
echo -e "\033[01;32m### Subindo os contianers ###\033[01;32m"
echo -e "\033[01;32m#############################\033[01;32m"
echo -e "\n"

sudo docker-compose up -d
###############

echo -e "\n\n"
echo -e "\033[01;32m#############################\033[01;32m"
echo -e "\033[01;32m### Aplicação rodando!!!! ###\033[01;32m"
echo -e "\033[01;32m#############################\033[01;32m"
