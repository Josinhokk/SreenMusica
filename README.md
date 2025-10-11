# 🎵 ScreenMusica

O **ScreenMusica** é uma aplicação desenvolvida em **Java**, utilizando **Spring Boot**, **JPA** e **PostgreSQL**, criada para aplicar conceitos de modelagem de classes, persistência de dados e integração com APIs externas.  
O sistema permite o **cadastro, listagem e busca de músicas e artistas**, além de integrar a **API do Gemini** para enriquecer as informações obtidas.

---

## 🚀 Tecnologias utilizadas

- **Java 17+**
- **Spring Boot**
- **JPA / Hibernate**
- **PostgreSQL**
- **API Gemini**
- **Maven**

---

## ⚙️ Pré-requisitos

Antes de executar o projeto, certifique-se de ter instalado:
- [Java JDK 17+](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- [PostgreSQL](https://www.postgresql.org/download/)
- [Maven](https://maven.apache.org/)
- Uma **chave de API** da [Gemini](https://ai.google.dev/gemini-api/docs/quickstart?hl=pt-br)

---

## 🗄️ Configuração do Banco de Dados

1. Crie um banco de dados no PostgreSQL, por exemplo:
   ```sql
   CREATE DATABASE screenmusica;
Configure o arquivo application.properties com suas credenciais


Adicione sua chave de API Gemini nas variáveis de ambiente

---

## 🧠 Funcionalidades

Cadastrar artistas

Cadastrar músicas

Listar músicas

Buscar músicas por artista

Pesquisar informações sobre artistas (via API Gemini)
