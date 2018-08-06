# puc-nasdaq
Projeto final da disciplina Javaee

# Mongo e Rabbitmq

Este projeto utilizar o MongoDB como repositório de dados e utilizar o Rabbitmq para processar as mensagens assincronas.
Para este projeto as seguintes imagens foram utilizadas abaixo:

~~~shell
docker run -p 27017:27017 --name mongodb -d mongo
docker run -d --hostname rabbitmq --name rabb
~~~

# Execução do projeto

Para executar o projeto basta executar a classe *PucnasdaqApplication.java*

# Bibliotecas Utilizadas

1. Spring Boot: Utilizada para criar serviços Rest
2. Lombok: Utilizada para automatizar a criação de metódos getters e setters
3. Spring boot amqp: Utilizada para conectar a aplicação ao RabbitMq
4. Spring boot data-mongodb: Utilizada para conectar ao MongoDB
5. Javax.mail: Utilizada para enviar e-mails na aplicação

# Arquivos de configuração

## Auth.properties
Para enviar e-mail na aplicação é necessário configurar o usuário e senha no arquivo *auth.properties*, localizado nos recursos do projeto. 

## Mail.properties
Configurações para conectar-se a um servidor smtp, neste exemplo foram utilizados os dados de e-mail do servidor smtp do google, para se conectar ao g-mail.

## Application.properties
Neste arquivo estão contidos os dados de conexão com o MongoDB

## Application.yml
Neste arquivo estão contidos os dados de conexão com o RabbitMq