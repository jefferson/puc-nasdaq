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
## Rotas

Após executar o projeto, a api estará disponível no endereço *http://localhost:8080*, com as seguintes toras:

1. Cadastro e visualização de acionistas: http://localhost:8080/api/v1/buyers - GET/POST
2. Cadastro e visualização de empresas: http://localhost:8080/api/v1/companies - GET/POST
3. Execução de transações: http://localhost:8080/api/v1/transactions/sell - POST

## Exemplos para o envio de dados

Para saber mais informações sobre a relação entre os objetos os mesmos podem ser consultados na recurso "domain", no projeto.

1. Acionnistas

```javascript
{
 "name": "Kinkas's",
 "email": "teste@gmail.com"
}
```

2. Empresas

```javascript
{
 "name": "Acme company",
 "maxStocks": 3,
 "initialValue": 60.89,
 "stocks": [
  {
   "name": "Ball",
   "initialValue": 1.89
  },
  {
   "name": "Ball 2",
   "initialValue": 0.89
  },	
 ]
}
```

2. Transações

```javascript
{
 "companyId": "5b67882aa60b82372cea4069",
 "buyerId": "5b678825a60b82372cea4068",
 "stockId": "69d174e1-e092-4b49-a4d4-3f673402bbdd",
 "currentValue": 3.50
}
```

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
