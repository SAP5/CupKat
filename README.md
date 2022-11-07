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
  - API REST e RESTfull
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
| Será retornado um array com todos as cores cadastradas no banco de dados |


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