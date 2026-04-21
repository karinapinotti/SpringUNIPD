````markdown
# 🌱 SpringUNIPD

Projeto desenvolvido como estudo de **Spring Boot** na pós-graduação **UNIPDS - Java**.

Esta primeira aula foca na **introdução ao Spring**, configuração do ambiente e criação de uma **API REST simples**.

---

## 🎯 Objetivo da Aula 1

- Entender o que é o **Spring Framework**
- Criar um projeto com **Spring Boot**
- Subir uma aplicação local
- Criar um endpoint REST básico (`/hello`)

---

## ⚙️ Tecnologias utilizadas

- Java 21+
- Spring Boot
- Maven
- Tomcat (embutido)

---

## 🚀 Como rodar o projeto

### 1. Pré-requisitos

Verifique se possui:

```bash
java -version
mvn -version
````

Caso não tenha Java:

```bash
sudo apt install openjdk-21-jdk
```

---

### 2. Executar o projeto

Na raiz do projeto:

```bash
mvn spring-boot:run
```

Ou rodar pela IDE (classe principal com `main`)

---

## 🌐 Acesso local

Após iniciar:

```bash
http://localhost:8080
```

---

## 🔗 Endpoint disponível

### Hello World

```bash
http://localhost:8080/hello
```

Resposta:

```text
Hello World!
```

---

## 📁 Estrutura do projeto

```
src/
 ├── main/
 │    ├── java/
 │    │    └── br/com/bpk/springunipds/
 │    │         ├── controller
 │    │         ├── model
 │    │         └── SpringunipdsApplication.java
 │    └── resources/
 │         └── application.properties
```

---

## 🧠 Conceitos aprendidos

### Spring Framework

Framework Java para desenvolvimento de aplicações (web, APIs, microsserviços)

### Spring Boot

Facilita o uso do Spring:

* Configuração automática
* Servidor embutido
* Menos código de setup

### REST API

* Comunicação via HTTP
* Métodos: GET, POST, PUT, DELETE
* Retorno geralmente em JSON

### Controller

Classe responsável por expor endpoints HTTP

Exemplo:

```java
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
}
```

---

## ⚠️ Problemas comuns

### 404 ao acessar "/"

Não existe endpoint na raiz
✔ Use `/hello`

---

### Erro HTTPS

Se acessar com:

```
https://localhost:8080
```

Vai dar erro

✔ Use:

```
http://localhost:8080
```

---

## 📚 Observação

Este repositório faz parte dos meus estudos contínuos em:

* Spring Boot
* APIs REST
* Boas práticas em Java

```

Se quiser, depois :contentReference[oaicite:0]{index=0}.
```
