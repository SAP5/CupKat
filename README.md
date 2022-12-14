<p align="center">
    <img src="http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge"/>
    <img src="http://img.shields.io/static/v1?label=MAVEN&message=1.8&color=red&style=for-the-badge"/>
    <img src="http://img.shields.io/static/v1?label=JAVA&message=11&color=blue&style=for-the-badge"/>
</p>

<h4 align="center">:construction: Projeto em construção :construction:</h4>

<img src="https://github.com/SAP5/CupKat/blob/master/src/main/resources/cupkat.jpeg" alt="logotipo CupKat" width="140px" align="right">

# 🍃 Projeto Interdisciplinar - CupKat - Backend ☕️🐱 - Fatec Zona Leste

Projeto feito durante o 3˚ semestre do curso de Desenvolvimento de Software Multiplataforma, tendo como objetivo o desenvolvimento de uma aplicação completa utilizando a linguagem JAVA no backend e MySQL como banco de dados.

## ⭐️ Habilidades

- Utilizar as habilidades aprendidas em aula e em estudos individuais da equipe: 
  - POO
  - JAVA
  - Spring Boot
  - API RESTful
  - JSON
  - Arquitetura MVC
  - Conexão com banco de dados MySQL

## 💻 Como iniciar o sistema em sua maquina local

1. Faça o clone do projeto:
```shell
git clone git@github.com:SAP5/CupKat.git
```
2. Abra o projeto na sua IDE de escolha:
```shell
mvn spring-boot:run
```

## 👩🏽‍💻🧑🏼‍💻 Como testar no Postman

1. Importar o [arquivo](https://github.com/SAP5/CupKat/blob/master/src/main/resources/CUPKAT.json)
2. Definir em qual ambiente você irá realizar os testes

### Local
```
http://localhost:8080/
```

### Produção
```
https://cupkat-test.herokuapp.com/
```

# 💡 Documentação da API

## Tamanho 👨‍👦👩‍👧

### Recuperar todos os Tamanhos

```http
GET /tamanhos/
```

| Descrição                                                                    |
|:-----------------------------------------------------------------------------|
| Será retornado um array com todos os tamanhos cadastrados no banco de dados  |


**Retorno em caso de sucesso**

```json
[
  {
    "id": 1,
    "nome": "PP",
    "tamanho": "500",
    "produtos": []
  },
  {
    "id": 2,
    "nome": "P",
    "tamanho": "600",
    "produtos": []
  },
  {
    "id": 3,
    "nome": "M",
    "tamanho": "700",
    "produtos": []
  },
  {
    "id": 4,
    "nome": "G",
    "tamanho": "750",
    "produtos": []
  },
  {
    "id": 5,
    "nome": "TAMANHO ÚNICO",
    "tamanho": "325",
    "produtos": []
  }
]
```

### Recuperar um Tamanho pelo id

```http
GET /tamanhos/{id}
```

| Parâmetro   | Tipo       | Descrição                                             |
| :---------- | :--------- | :---------------------------------------------------- |
| `id`        | `int`      | **Obrigatório**. Parâmetros devem ser passados na URL |

| Descrição                                                   |
|:------------------------------------------------------------|
| Será retornado o tamanho com o id correspondente ao enviado |

**Retorno em caso de sucesso**

```json
{
	"id": 5,
	"nome": "TAMANHO ÚNICO",
	"tamanho": "325",
	"produtos": []
}
```

**Retorno em caso de Id não encontrado**

```json
{
	"title": "Objeto não encontrado",
	"status": 404,
	"message": "Tamanho não encontrado!",
	"timeStamp": "2022-11-07T15:20:20.073393"
}
```

## Cor 🔴🟠🟣🔵

### Recuperar todas as Cores

```http
GET /cores/
```

| Descrição                                                                |
|:-------------------------------------------------------------------------|
| Será retornado um array com todas as cores cadastradas no banco de dados |


**Retorno em caso de sucesso**

```json
[
  {
    "id": 1,
    "nome": "Azul",
    "cor": "#4287f5",
    "produtos": []
  },
  {
    "id": 2,
    "nome": "Preto",
    "cor": "#03060a",
    "produtos": []
  },
  {
    "id": 3,
    "nome": "Branco",
    "cor": "#ffffff",
    "produtos": []
  },
  {
    "id": 4,
    "nome": "Vermelho",
    "cor": "#f71b1b",
    "produtos": []
  },
  {
    "id": 5,
    "nome": "Cinza",
    "cor": "#877f7f",
    "produtos": []
  }
]
```

### Recuperar uma Cor pelo id

```http
GET /cores/{id}
```

| Parâmetro   | Tipo       | Descrição                                             |
| :---------- | :--------- | :---------------------------------------------------- |
| `id`        | `int`      | **Obrigatório**. Parâmetros devem ser passados na URL |

| Descrição                                               |
|:--------------------------------------------------------|
| Será retornado a cor com o id correspondente ao enviado |

**Retorno em caso de sucesso**

```json
{
  "id": 5,
  "nome": "Cinza",
  "cor": "#877f7f",
  "produtos": []
}
```

**Retorno em caso de Id não encontrado**

```json
{
	"title": "Objeto não encontrado",
	"status": 404,
	"message": "Cor não encontrada!",
	"timeStamp": "2022-11-07T15:20:20.073393"
}
```

## Categoria 👜

### Recuperar todas as Categorias

```http
GET /categorias/
```

| Descrição                                                                     |
|:------------------------------------------------------------------------------|
| Será retornado um array com todas as categorias cadastradas no banco de dados |


**Retorno em caso de sucesso**

```json
[
  {
    "id": 5,
    "created_at": null,
    "updated_at": null,
    "status": 1,
    "titulo": "Teste 2",
    "descricao": "testettetetetetetet",
    "produtos": []
  }
]
```

### Recuperar uma Categoria pelo id

```http
GET /categorias/by_id/{id}
```

| Parâmetro   | Tipo       | Descrição                                             |
| :---------- | :--------- | :---------------------------------------------------- |
| `id`        | `int`      | **Obrigatório**. Parâmetros devem ser passados na URL |

| Descrição                                                     |
|:--------------------------------------------------------------|
| Será retornado a categoria com o id correspondente ao enviado |

**Retorno em caso de sucesso**

```json
  {
  "id": 5,
  "created_at": null,
  "updated_at": null,
  "status": 1,
  "titulo": "Teste 2",
  "descricao": "testettetetetetetet",
  "produtos": []
}
```

**Retorno em caso de Id não encontrado**

```json
{
	"title": "Objeto não encontrado",
	"status": 404,
	"message": "Categoria não encontrada!",
	"timeStamp": "2022-11-07T15:20:20.073393"
}
```

### Cadastrar uma Categoria

```http
POST /categorias/
```

| Corpo da requisição | Tipo       | Descrição                                               |
|:--------------------| :--------- | :------------------------------------------------------ |
| `titulo, descricao` | `json`     | **Obrigatório**. Todos os campos no corpo da requisição |

| Descrição                                                          |
|:-------------------------------------------------------------------|
| Será retornado um status correspondente ao resultado da requisição |

**Formato do corpo da requisição**
```json
{
  "titulo": "Teste 2",
  "descricao": "testettetetetetetet"
}
```

**Retorno em caso de sucesso**

```
status: 201 CREATED
```

### Atualizar uma Categoria pelo id

```http
PUT /categorias/by_id/{id}
```

| Parâmetro   | Tipo       | Descrição                                             |
| :---------- | :--------- | :---------------------------------------------------- |
| `id`        | `int`      | **Obrigatório**. Parâmetros devem ser passados na URL |

| Corpo da requisição | Tipo       | Descrição                                               |
|:--------------------| :--------- | :------------------------------------------------------ |
| `titulo, descricao` | `json`     | **Obrigatório**. Todos os campos no corpo da requisição |

| Descrição                                                          |
|:-------------------------------------------------------------------|
| Será retornado um status correspondente ao resultado da requisição |

**Formato do corpo da requisição**
```json
{
  "titulo" : "Vestuario",
  "descricao" : "Roupas e acessórios"
}
```

**Retorno em caso de sucesso**
```
status: 200 OK
```

**Retorno em caso de Id não encontrado**

```json
{
	"title": "Objeto não encontrado",
	"status": 404,
	"message": "Categoria não encontrada!",
	"timeStamp": "2022-11-07T15:20:20.073393"
}
```

### Deletar uma Categoria pelo id

```http
DELETE /categorias/delete/{id}
```

| Parâmetro   | Tipo       | Descrição                                             |
| :---------- | :--------- | :---------------------------------------------------- |
| `id`        | `int`      | **Obrigatório**. Parâmetros devem ser passados na URL |

| Descrição                                                     |
|:--------------------------------------------------------------|
| Será retornado a categoria com o id correspondente ao enviado |

**Retorno em caso de sucesso**

```json
{
  "titulo" : "Vestuario",
  "descricao" : "Roupas e acessórios"
}
```

**Retorno em caso de Id não encontrado**

```json
{
	"title": "Objeto não encontrado",
	"status": 404,
	"message": "Categoria não encontrada!",
	"timeStamp": "2022-11-07T15:20:20.073393"
}
```

## Modelo 👚👕

### Recuperar todos os Modelos

```http
GET /modelos/
```

| Descrição                                                                  |
|:---------------------------------------------------------------------------|
| Será retornado um array com todos os modelos cadastrados no banco de dados |


**Retorno em caso de sucesso**

```json
[
  {
    "id": 3,
    "created_at": null,
    "updated_at": null,
    "status": 1,
    "titulo": "Teste",
    "precoCusto": 123.50,
    "descricao": "testettetetetetetet",
    "produtos": []
  }
]
```

### Recuperar um Modelo pelo id

```http
GET /modelos/by_id/{id}
```

| Parâmetro   | Tipo       | Descrição                                             |
| :---------- | :--------- | :---------------------------------------------------- |
| `id`        | `int`      | **Obrigatório**. Parâmetros devem ser passados na URL |

| Descrição                                                  |
|:-----------------------------------------------------------|
| Será retornado o modelo com o id correspondente ao enviado |

**Retorno em caso de sucesso**

```json
{
  "id": 3,
  "created_at": null,
  "updated_at": null,
  "status": 1,
  "titulo": "Teste",
  "precoCusto": 123.50,
  "descricao": "testettetetetetetet",
  "produtos": []
}
```

**Retorno em caso de Id não encontrado**

```json
{
	"title": "Objeto não encontrado",
	"status": 404,
	"message": "Modelo não encontrado!",
	"timeStamp": "2022-11-07T15:20:20.073393"
}
```

### Cadastrar um Modelo

```http
POST /modelos/
```

| Corpo da requisição             | Tipo       | Descrição                                               |
|:--------------------------------| :--------- | :------------------------------------------------------ |
| `titulo, precoCusto, descricao` | `json`     | **Obrigatório**. Todos os campos no corpo da requisição |

| Descrição                                                          |
|:-------------------------------------------------------------------|
| Será retornado um status correspondente ao resultado da requisição |

**Formato do corpo da requisição**
```json
{
  "titulo" : "Teste",
  "precoCusto" : 123.5,
  "descricao" : "testettetetetetetet"
}
```

**Retorno em caso de sucesso**

```
status: 201 CREATED
```

### Atualizar um Modelo pelo id

```http
PUT /modelos/by_id/{id}
```

| Parâmetro   | Tipo       | Descrição                                             |
| :---------- | :--------- | :---------------------------------------------------- |
| `id`        | `int`      | **Obrigatório**. Parâmetros devem ser passados na URL |

| Corpo da requisição             | Tipo       | Descrição                                               |
|:--------------------------------| :--------- | :------------------------------------------------------ |
| `titulo, precoCusto, descricao` | `json`     | **Obrigatório**. Todos os campos no corpo da requisição |

| Descrição                                                          |
|:-------------------------------------------------------------------|
| Será retornado um status correspondente ao resultado da requisição |

**Formato do corpo da requisição**
```json
{
  "titulo" : "Teste",
  "precoCusto" : 123.5,
  "descricao" : "testettetetetetetet"
}
```

**Retorno em caso de sucesso**
```
status: 200 OK
```

**Retorno em caso de Id não encontrado**

```json
{
	"title": "Objeto não encontrado",
	"status": 404,
	"message": "Modelo não encontrado!",
	"timeStamp": "2022-11-07T15:20:20.073393"
}
```

### Deletar um Modelo pelo id

```http
DELETE /modelos/delete/{id}
```

| Parâmetro   | Tipo       | Descrição                                             |
| :---------- | :--------- | :---------------------------------------------------- |
| `id`        | `int`      | **Obrigatório**. Parâmetros devem ser passados na URL |

| Descrição                                                     |
|:--------------------------------------------------------------|
| Será retornado a categoria com o id correspondente ao enviado |

**Retorno em caso de sucesso**

```json
{
  "titulo": "Teste",
  "precoCusto": 123.50,
  "descricao": "testettetetetetetet"
}
```

**Retorno em caso de Id não encontrado**

```json
{
	"title": "Objeto não encontrado",
	"status": 404,
	"message": "Modelo não encontrado!",
	"timeStamp": "2022-11-07T15:20:20.073393"
}
```

## Cliente 👩🏼👩🏽‍🦱👨🏾👨🏻‍🦱

### Recuperar todos os Clientes

```http
GET /clientes/
```

| Descrição                                                                   |
|:----------------------------------------------------------------------------|
| Será retornado um array com todos os clientes cadastrados no banco de dados |


**Retorno em caso de sucesso**

```json
[
  {
    "id": 1,
    "status": 1,
    "nome": "Giovanna",
    "email": "teste23@gmail.com"
  }
]
```

### Recuperar um Cliente pelo id

```http
GET /clientes/by_id/{id}
```

| Parâmetro   | Tipo       | Descrição                                             |
| :---------- | :--------- | :---------------------------------------------------- |
| `id`        | `int`      | **Obrigatório**. Parâmetros devem ser passados na URL |

| Descrição                                                   |
|:------------------------------------------------------------|
| Será retornado o cliente com o id correspondente ao enviado |

**Retorno em caso de sucesso**

```json
{
  "id": 1,
  "status": 1,
  "nome": "Giovanna",
  "email": "teste23@gmail.com"
}
```

**Retorno em caso de Id não encontrado**

```json
{
	"title": "Objeto não encontrado",
	"status": 404,
	"message": "Cliente não encontrado!",
	"timeStamp": "2022-11-07T15:20:20.073393"
}
```

### Recuperar uma lista de Clientes pelo email

```http
GET /clientes/by_email/{email}
```

| Parâmetro | Tipo     | Descrição                                             |
|:----------|:---------| :---------------------------------------------------- |
| `email`   | `String` | **Obrigatório**. Parâmetros devem ser passados na URL |

| Descrição                                                                |
|:-------------------------------------------------------------------------|
| Será retornada um cliente cujo email esteja cadastrado no banco de dados |

**Retorno em caso de sucesso**

```json
{
  "id": 1,
  "status": 1,
  "nome": "Giovanna",
  "email": "teste23@gmail.com"
}
```

**Retorno em caso de correspondência não encontrada**

```json
{
  "title": "Objeto não encontrado",
  "status": 404,
  "message": "Nenhum usuário encontrado",
  "timeStamp": "2022-11-14T22:31:36.1412154"
}
```

### Cadastrar um Cliente

```http
POST /clientes/
```

| Corpo da requisição       | Tipo       | Descrição                                               |
|:--------------------------| :--------- | :------------------------------------------------------ |
| `nome, cpf, email, senha` | `json`     | **Obrigatório**. Todos os campos no corpo da requisição |

| Descrição                                                          |
|:-------------------------------------------------------------------|
| Será retornado um status correspondente ao resultado da requisição |

**Formato do corpo da requisição**
```json
{
  "nome" : "Giovanna",
  "cpf" : "000.000.001-97",
  "email" : "teste23@gmail.com",
  "senha" : "Teste2@124"
}
```

**Retorno em caso de sucesso**

```
status: 201 CREATED
```

### Atualizar um Cliente pelo id

```http
PUT /clientes/by_id/{id}
```

| Parâmetro   | Tipo       | Descrição                                             |
| :---------- | :--------- | :---------------------------------------------------- |
| `id`        | `int`      | **Obrigatório**. Parâmetros devem ser passados na URL |

| Corpo da requisição       | Tipo       | Descrição                                               |
|:--------------------------| :--------- | :------------------------------------------------------ |
| `nome, cpf, email, senha` | `json`     | **Obrigatório**. Todos os campos no corpo da requisição |

| Descrição                                                          |
|:-------------------------------------------------------------------|
| Será retornado um status correspondente ao resultado da requisição |

**Formato do corpo da requisição**
```json
{
  "nome" : "teste 2",
  "cpf" : "000.000.001-91",
  "email" : "teste@teste.com",
  "senha" : "Teste@123"
}
```

**Retorno em caso de sucesso**
```
status: 200 OK
```

**Retorno em caso de Id não encontrado**

```json
{
	"title": "Objeto não encontrado",
	"status": 404,
	"message": "Cliente não encontrado!",
	"timeStamp": "2022-11-07T15:20:20.073393"
}
```

### Deletar um Cliente pelo id

```http
DELETE /clientes/delete/{id}
```

| Parâmetro   | Tipo       | Descrição                                             |
| :---------- | :--------- | :---------------------------------------------------- |
| `id`        | `int`      | **Obrigatório**. Parâmetros devem ser passados na URL |

| Descrição                                                   |
|:------------------------------------------------------------|
| Será retornado a cliente com o id correspondente ao enviado |

**Retorno em caso de sucesso**

```json
{
  "id": 1,
  "status": 1,
  "nome": "Giovanna",
  "email": "teste23@gmail.com"
}
```

**Retorno em caso de Id não encontrado**

```json
{
	"title": "Objeto não encontrado",
	"status": 404,
	"message": "Cliente não encontrado!",
	"timeStamp": "2022-11-07T15:20:20.073393"
}
```

## Funcionário 🧑🏻‍💼👨🏼‍💼👩🏽‍💼👨🏿‍💼

### Recuperar todos os Funcionários

```http
GET /funcionarios/
```

| Descrição                                                                       |
|:--------------------------------------------------------------------------------|
| Será retornado um array com todos os funcionários cadastrados no banco de dados |


**Retorno em caso de sucesso**

```json
[
  {
    "id": 1,
    "status": 1,
    "nome": "Giovanna",
    "email": "teste23@gmail.com"
  }
]
```

### Recuperar um Funcionário pelo id

```http
GET /funcionarios/by_id/{id}
```

| Parâmetro   | Tipo       | Descrição                                             |
| :---------- | :--------- | :---------------------------------------------------- |
| `id`        | `int`      | **Obrigatório**. Parâmetros devem ser passados na URL |

| Descrição                                                       |
|:----------------------------------------------------------------|
| Será retornado o funcionário com o id correspondente ao enviado |

**Retorno em caso de sucesso**

```json
{
  "id": 1,
  "status": 1,
  "nome": "Giovanna",
  "email": "teste23@gmail.com"
}
```

**Retorno em caso de Id não encontrado**

```json
{
	"title": "Objeto não encontrado",
	"status": 404,
	"message": "Funcionário não encontrado!",
	"timeStamp": "2022-11-07T15:20:20.073393"
}
```

### Recuperar um Funcionário pelo email

```http
GET /funcionarios/by_email/{email}
```

| Parâmetro | Tipo     | Descrição                                             |
|:----------|:---------| :---------------------------------------------------- |
| `email`   | `String` | **Obrigatório**. Parâmetros devem ser passados na URL |

| Descrição                                                                   |
|:----------------------------------------------------------------------------|
| Será retornada um funcionário cujo email esteja cadastado no banco de dados |

**Retorno em caso de sucesso**

```json
{
  "id": 1,
  "status": 1,
  "nome": "Giovanna",
  "email": "teste23@gmail.com"
}
```

**Retorno em caso de correspondência não encontrada**

```json
{
  "title": "Objeto não encontrado",
  "status": 404,
  "message": "Nenhum funcionário encontrado",
  "timeStamp": "2022-11-14T22:31:36.1412154"
}
```

### Cadastrar um Funcionário

```http
POST /funcionarios/
```

| Corpo da requisição  | Tipo       | Descrição                                               |
|:---------------------| :--------- | :------------------------------------------------------ |
| `nome, email, senha` | `json`     | **Obrigatório**. Todos os campos no corpo da requisição |

| Descrição                                                          |
|:-------------------------------------------------------------------|
| Será retornado um status correspondente ao resultado da requisição |

**Formato do corpo da requisição**
```json
{
  "nome" : "Giovanna",
  "email" : "teste23@gmail.com",
  "senha" : "Teste01@123$"
}
```

**Retorno em caso de sucesso**

```
status: 201 CREATED
```

### Atualizar um Funcionário pelo id

```http
PUT /funcionarios/by_id/{id}
```

| Parâmetro   | Tipo       | Descrição                                             |
| :---------- | :--------- | :---------------------------------------------------- |
| `id`        | `int`      | **Obrigatório**. Parâmetros devem ser passados na URL |

| Corpo da requisição     | Tipo       | Descrição                                               |
|:------------------------| :--------- | :------------------------------------------------------ |
| `nome, email, senha`    | `json`     | **Obrigatório**. Todos os campos no corpo da requisição |

| Descrição                                                          |
|:-------------------------------------------------------------------|
| Será retornado um status correspondente ao resultado da requisição |

**Formato do corpo da requisição**
```json
{
  "nome" : "teste 2",
  "email" : "teste@teste.com",
  "senha" : "Teste@123"
}
```

**Retorno em caso de sucesso**
```
status: 200 OK
```

**Retorno em caso de Id não encontrado**

```json
{
	"title": "Objeto não encontrado",
	"status": 404,
	"message": "Funcionário não encontrado!",
	"timeStamp": "2022-11-07T15:20:20.073393"
}
```

### Deletar um Funcionário pelo id

```http
DELETE /funcionarios/delete/{id}
```

| Parâmetro   | Tipo       | Descrição                                             |
| :---------- | :--------- | :---------------------------------------------------- |
| `id`        | `int`      | **Obrigatório**. Parâmetros devem ser passados na URL |

| Descrição                                                       |
|:----------------------------------------------------------------|
| Será retornado a funcionário com o id correspondente ao enviado |

**Retorno em caso de sucesso**

```json
{
  "id": 1,
  "status": 1,
  "nome": "Giovanna",
  "email": "teste23@gmail.com"
}
```

**Retorno em caso de Id não encontrado**

```json
{
	"title": "Objeto não encontrado",
	"status": 404,
	"message": "Funcionário não encontrado!",
	"timeStamp": "2022-11-07T15:20:20.073393"
}
```

## Produto ☕️🥤

### Recuperar todos os Produtos

```http
GET /produtos/
```

| Descrição                                                                   |
|:----------------------------------------------------------------------------|
| Será retornado um array com todos os produtos cadastrados no banco de dados |


**Retorno em caso de sucesso**

```json
[
  {
    "id": 1,
    "created_at": null,
    "updated_at": null,
    "status": 1,
    "nome": "Teste 2",
    "descricao": "a",
    "lucro": 10.0,
    "estoque": 10,
    "imagem": null
  },
  {
    "id": 3,
    "created_at": null,
    "updated_at": null,
    "status": 1,
    "nome": "teste",
    "descricao": "testettetetetetetet",
    "lucro": 10.0,
    "estoque": 10,
    "imagem": null
  },
  {
    "id": 4,
    "created_at": null,
    "updated_at": null,
    "status": 1,
    "nome": "teste",
    "descricao": "testettetetetetetet",
    "lucro": 10.0,
    "estoque": 10,
    "imagem": null
  },
  {
    "id": 5,
    "created_at": null,
    "updated_at": null,
    "status": 1,
    "nome": "abobrinha",
    "descricao": "testettetetetetetet",
    "lucro": 10.0,
    "estoque": 10,
    "imagem": null
  },
  {
    "id": 6,
    "created_at": null,
    "updated_at": null,
    "status": 1,
    "nome": "abobrinha",
    "descricao": "testettetetetetetet",
    "lucro": 10.0,
    "estoque": 10,
    "imagem": null
  }
]
```

### Recuperar um Produto pelo id

```http
GET /produtos/by_id/{id}
```

| Parâmetro   | Tipo       | Descrição                                             |
| :---------- | :--------- | :---------------------------------------------------- |
| `id`        | `int`      | **Obrigatório**. Parâmetros devem ser passados na URL |

| Descrição                                                   |
|:------------------------------------------------------------|
| Será retornado o produto com o id correspondente ao enviado |

**Retorno em caso de sucesso**

```json
{
  "id": 1,
  "created_at": null,
  "updated_at": null,
  "status": 1,
  "nome": "Teste 2",
  "descricao": "a",
  "lucro": 10.0,
  "estoque": 10,
  "imagem": null
}
```

**Retorno em caso de Id não encontrado**

```json
{
	"title": "Objeto não encontrado",
	"status": 404,
	"message": "Produto não encontrado!",
	"timeStamp": "2022-11-07T15:20:20.073393"
}
```

### Recuperar Produtos pelo nome

```http
GET /produtos/by_name/{name}
```

| Parâmetro | Tipo     | Descrição                                             |
|:----------|:---------| :---------------------------------------------------- |
| `name`    | `String` | **Obrigatório**. Parâmetros devem ser passados na URL |

| Descrição                                                                    |
|:-----------------------------------------------------------------------------|
| Será retornado um array de produtos cujo nome seja correspondente ao enviado |

**Retorno em caso de sucesso**

```json
[
  {
    "id": 1,
    "created_at": null,
    "updated_at": null,
    "status": 1,
    "nome": "Teste 2",
    "descricao": "a",
    "lucro": 10.0,
    "estoque": 10,
    "imagem": null
  }
]
```

**Retorno em caso correspondência não encontrada**

```json
[]
```

### Cadastrar um Produto

```http
POST /produtos/
```

| Corpo da requisição                                                                | Tipo       | Descrição                                               |
|:-----------------------------------------------------------------------------------| :--------- | :------------------------------------------------------ |
| `nome, descricao, precoCusto, lucro, estoque, cores, tamanhos, categorias, modelo` | `json`     | **Obrigatório**. Todos os campos no corpo da requisição |

| Descrição                                                          |
|:-------------------------------------------------------------------|
| Será retornado um status correspondente ao resultado da requisição |

**Formato do corpo da requisição**
```json
{
  "nome" : "abobrinha",
  "descricao" : "testettetetetetetet",
  "precoCusto" : 10.5,
  "lucro" : 10.0,
  "estoque" : 10,
  "cores" : [1, 2, 3],
  "tamanhos" : [1, 2],
  "categorias" : [5],
  "modelo" : 3
}
```

**Retorno em caso de sucesso**

```
status: 201 CREATED
```

### Atualizar um Produto pelo id

```http
PUT /produtos/by_id/{id}
```

| Parâmetro   | Tipo       | Descrição                                             |
| :---------- | :--------- | :---------------------------------------------------- |
| `id`        | `int`      | **Obrigatório**. Parâmetros devem ser passados na URL |

| Corpo da requisição                                                                | Tipo       | Descrição                                               |
|:-----------------------------------------------------------------------------------| :--------- | :------------------------------------------------------ |
| `nome, descricao, precoCusto, lucro, estoque, cores, tamanhos, categorias, modelo` | `json`     | **Obrigatório**. Todos os campos no corpo da requisição |

| Descrição                                                          |
|:-------------------------------------------------------------------|
| Será retornado um status correspondente ao resultado da requisição |

**Formato do corpo da requisição**
```json
{
  "nome" : "Teste 2",
  "descricao" : "a",
  "precoCusto" : 10.5,
  "lucro" : 10.0,
  "estoque" : 10,
  "cores" : [1, 2, 3],
  "tamanhos" : [1, 2],
  "categorias" : [5],
  "modelo" : 3
}
```

**Retorno em caso de sucesso**
```
status: 200 OK
```

**Retorno em caso de Id não encontrado**

```json
{
	"title": "Objeto não encontrado",
	"status": 404,
	"message": "Produto não encontrado!",
	"timeStamp": "2022-11-07T15:20:20.073393"
}
```

### Deletar um Produto pelo id

```http
DELETE /produtos/delete/{id}
```

| Parâmetro   | Tipo       | Descrição                                             |
| :---------- | :--------- | :---------------------------------------------------- |
| `id`        | `int`      | **Obrigatório**. Parâmetros devem ser passados na URL |

| Descrição                                                   |
|:------------------------------------------------------------|
| Será retornado a produto com o id correspondente ao enviado |

**Retorno em caso de sucesso**

```json
{
  "id": 5,
  "created_at": null,
  "updated_at": null,
  "status": 1,
  "nome": "abobrinha",
  "descricao": "testettetetetetetet",
  "lucro": 10.0,
  "estoque": 10,
  "imagem": null
}
```

**Retorno em caso de Id não encontrado**

```json
{
	"title": "Objeto não encontrado",
	"status": 404,
	"message": "Produto não encontrado!",
	"timeStamp": "2022-11-07T15:20:20.073393"
}
```