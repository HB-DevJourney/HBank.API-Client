### 💳 HBank – Banco Digital Fictício

![Java](https://img.shields.io/badge/Java-21-blue?logo=java)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.4-green?logo=springboot)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-blue?logo=postgresql)
![Docker](https://img.shields.io/badge/Docker-Orchestrator-blue?logo=docker)
![JUnit 5](https://img.shields.io/badge/JUnit_5-Testing-red?logo=java)
![Mockito](https://img.shields.io/badge/Mockito-Mocking-yellow?logo=java)

**HBank** é um projeto de banco digital criado com fins educacionais e de portfólio, com o objetivo de simular o funcionamento de uma instituição financeira moderna. O projeto adota a arquitetura de **microserviços**, promovendo escalabilidade, separação de responsabilidades e manutenibilidade do sistema.

#### 🚀 Objetivos

- Aprendizado prático sobre **microserviços** com **Spring Boot**
- Aplicação de conceitos de **boas práticas em API REST**
- Simulação de processos bancários reais, como criação de contas, gerenciamento de saldo, aprovação de novos clientes e muito mais

#### 🧩 Arquitetura

- **API de Clientes:** Responsável pelo cadastro, autenticação, movimentações e visualização de contas
- **API de Gerentes:** Responsável pela aprovação de novas contas e gerenciamento administrativo
- **API de Autenticação:** Responsável por login, geração e validação de tokens JWT para segurança e controle de acesso
- Comunicação entre APIs pode ser feita via **fila de mensagens**, garantindo desacoplamento e tolerância a falhas

#### 🛠️ Tecnologias Utilizadas

- Java 21 + Spring Boot
- Spring Web, Spring Data JPA, Spring Security + JWT
- Testes com JUnit 5 + Mockito (padrão BDD)
- Banco de dados relacional (PostgreSQL)
- Mensageria com RabbitMQ
- Docker e Docker Compose para orquestração
- Swagger para documentação de APIs

#### 📚 Status

Projeto em andamento com foco em:

- Testes unitários e de integração
- Aplicação de princípios SOLID e Clean Code
- Preparação para deploy com CI/CD

#### 📦 Como Rodar o Projeto

```bash
# Clone o repositório
$ git clone https://github.com/seu-usuario/hbank.git

# Acesse as pastas de cada microserviço
$ cd hbank/autenticacao-api
$ cd hbank/cliente-api
$ cd hbank/gerente-api

# Suba os serviços com Docker Compose
$ docker-compose up --build
```

#### 🔗 Endpoints Disponíveis

Documentação Swagger disponível em:

- `http://localhost:8080/swagger-ui.html` (Autenticação API)
- `http://localhost:8081/swagger-ui.html` (Cliente API)
- `http://localhost:8082/swagger-ui.html` (Gerente API)
