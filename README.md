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
    "nome": "Giovanna"
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
  "nome": "Giovanna"
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
DELETE /modelos/delete/{id}
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
  "nome": "Giovanna"
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