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

docker_image=$(docker images server)

if [[ ! -z "${docker_image}" ]]; then
	echo -e "\033[01;32mApagando a imagem Server....\033[01;32m"
	echo -e "\n"
	docker rmi -f $docker_image
	echo -e "\n"
fi

cd Server/
rm -rf target/
mvn clean install -DskipTests
###############

cd ../
echo -e "\n\n\n"

### Gateway ###
echo -e "\033[01;32m###################\033[01;32m"
echo -e "\033[01;32m###################\033[01;32m"
echo -e "\033[01;32m##### Gateway #####\033[01;32m"
echo -e "\033[01;32m###################\033[01;32m"
echo -e "\033[01;32m###################\033[01;32m"

docker_image=$(docker images gateway)

if [[ ! -z "${docker_image}" ]]; then
	echo -e "\033[01;32mApagando a imagem Gateway....\033[01;32m"
	echo -e "\n"
	docker rmi -f $docker_image
	echo -e "\n"
fi

cd Gateway/
rm -rf target/
mvn clean install -DskipTests
###############

cd ../
echo -e "\n\n\n"

### Pagamentos ###
echo -e "\033[01;32m######################\033[01;32m"
echo -e "\033[01;32m######################\033[01;32m"
echo -e "\033[01;32m##### Pagamentos #####\033[01;32m"
echo -e "\033[01;32m######################\033[01;32m"
echo -e "\033[01;32m######################\033[01;32m"

docker_image=$(docker images pagamentos)

if [[ ! -z "${docker_image}" ]]; then
	echo -e "\033[01;32mApagando a imagem Pagamentos....\033[01;32m"
	echo -e "\n"
	docker rmi -f $docker_image
	echo -e "\n"
fi

cd Pagamentos/
rm -rf target/
mvn clean install -Pdocker -DskipTests
###############

cd ../
echo -e "\n\n\n"

### Pedidos ###
echo -e "\033[01;32m###################\033[01;32m"
echo -e "\033[01;32m###################\033[01;32m"
echo -e "\033[01;32m##### Pedidos #####\033[01;32m"
echo -e "\033[01;32m###################\033[01;32m"
echo -e "\033[01;32m###################\033[01;32m"

docker_image=$(docker images pedidos)

if [[ ! -z "${docker_image}" ]]; then
	echo -e "\033[01;32mApagando a imagem Pedidos....\033[01;32m"
	echo -e "\n"
	docker rmi -f $docker_image
	echo -e "\n"
fi

cd Pedidos/
rm -rf target/
mvn clean install -Pdocker -DskipTests
###############

cd ../
echo -e "\n\n\n"

### Avaliacao ###
echo -e "\033[01;32m#####################\033[01;32m"
echo -e "\033[01;32m#####################\033[01;32m"
echo -e "\033[01;32m##### Avaliacao #####\033[01;32m"
echo -e "\033[01;32m#####################\033[01;32m"
echo -e "\033[01;32m#####################\033[01;32m"

docker_image=$(docker images avaliacao)

if [[ ! -z "${docker_image}" ]]; then
	echo -e "\033[01;32mApagando a imagem Avaliacao....\033[01;32m"
	echo -e "\n"
	docker rmi -f $docker_image
	echo -e "\n"
fi

cd Avaliacao/
rm -rf target/
mvn clean install -DskipTests
###############

cd ../
echo -e "\n\n\n"

### Docker ###
echo -e "\033[01;32m##################\033[01;32m"
echo -e "\033[01;32m##################\033[01;32m"
echo -e "\033[01;32m##### Docker #####\033[01;32m"
echo -e "\033[01;32m##################\033[01;32m"
echo -e "\033[01;32m##################\033[01;32m"

sudo docker-compose build
sudo docker-compose up -d
###############
