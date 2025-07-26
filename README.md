# 📦 Stockly - Gerenciamento de Estoque

O **Stockly** é um sistema de gerenciamento de estoque inteligente desenvolvido com **Spring Boot** e **MySQL**. Ele permite o cadastro de requisições de compra, controle de estoque e integração com APIs externas simuladas.

---

## ✨ Funcionalidades

- ✅ Cadastro de requisições de compra
- 📦 Controle de quantidade em estoque
- 🔐 Integração com serviço de autenticação externo (simulado via Mockoon)
- 🧠 Regras de negócio automatizadas para reposição
- 📊 Estrutura preparada para expansão com microserviços

---

## 📁 Tecnologias utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- Mockoon (API mock)
- Maven ou Gradle

---

## ⚙️ Requisitos para rodar o projeto

### ✅ Pré-requisitos

- Java 17+
- MySQL Server
- IDE (IntelliJ, Eclipse, VSCode etc.)
- [Mockoon](https://mockoon.com/) (para simular APIs externas)

---

### 🔧 Configurando o MySQL

1. **Crie o banco de dados:**

```sql
CREATE DATABASE stockly;
```


### ⚙️ Configuração do arquivo `application.properties`

Crie ou edite o arquivo `src/main/resources/application.properties` com o conteúdo abaixo. Substitua `SUA_SENHA_DO_MYSQL` pela sua senha real do MySQL:

```properties
spring.application.name=smartstock

app.client-id=ABC
app.client-secret=DEF

api.auth-url=http://localhost:3000
api.purchase-sector-url=http://localhost:3000

spring.datasource.url=jdbc:mysql://localhost:3306/stockly?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=SUA_SENHA_DO_MYSQL
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

spring.sql.init.mode=always
spring.jpa.defer-datasource-initialization=true
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
```

### 🛠️ Simulação de APIs Externas com Mockoon

Para facilitar o desenvolvimento, disponibilizamos um ambiente Mockoon já configurado.

**Passos:**

1. Baixe e instale o [Mockoon](https://mockoon.com/).  
2. Importe o arquivo `mockoon-environment.json` (disponível na raiz do projeto).  
3. Inicie o servidor mock na porta `3000`.  
4. As APIs simuladas estarão disponíveis para autenticação e requisições de compra.

## 🚀 Como rodar

Com o Maven instalado:

```bash
./mvnw spring-boot:run
```

Ou rode diretamente pela sua IDE (ex: IntelliJ IDEA).

---

Desenvolvido por Henrique Lindman ✨