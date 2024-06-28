#!/bin/bash

### Server ###
echo -e "\033[01;32m##############\033[01;32m"
echo -e "\033[01;32m##############\033[01;32m"
echo -e "\033[01;32m### Server ###\033[01;32m"
echo -e "\033[01;32m##############\033[01;32m"
echo -e "\033[01;32m##############\033[01;32m"

cd Server/
rm -rf target/
mvn clean install
###############

cd ../
echo -e "\n\n\n"

### Gateway ###
echo -e "\033[01;32m###############\033[01;32m"
echo -e "\033[01;32m###############\033[01;32m"
echo -e "\033[01;32m### Gateway ###\033[01;32m"
echo -e "\033[01;32m###############\033[01;32m"
echo -e "\033[01;32m###############\033[01;32m"

cd Gateway/
rm -rf target/
mvn clean install
###############

cd ../
echo -e "\n\n\n"

### Pagamentos ###
echo -e "\033[01;32m##################\033[01;32m"
echo -e "\033[01;32m##################\033[01;32m"
echo -e "\033[01;32m### Pagamentos ###\033[01;32m"
echo -e "\033[01;32m##################\033[01;32m"
echo -e "\033[01;32m##################\033[01;32m"

cd Pagamentos/
rm -rf target/
mvn clean install
###############

cd ../
echo -e "\n\n\n"

### Pedidos ###
echo -e "\033[01;32m###############\033[01;32m"
echo -e "\033[01;32m###############\033[01;32m"
echo -e "\033[01;32m### Pedidos ###\033[01;32m"
echo -e "\033[01;32m###############\033[01;32m"
echo -e "\033[01;32m###############\033[01;32m"

cd Pedidos/
rm -rf target/
mvn clean install
###############

cd ../
echo -e "\n\n\n"

### Docker ###
echo -e "\033[01;32m##############\033[01;32m"
echo -e "\033[01;32m##############\033[01;32m"
echo -e "\033[01;32m### Docker ###\033[01;32m"
echo -e "\033[01;32m##############\033[01;32m"
echo -e "\033[01;32m##############\033[01;32m"

sudo docker-compose build
sudo docker-compose up -d
###############