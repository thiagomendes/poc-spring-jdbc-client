
# POC Spring JDBC Client

Este é um projeto simples em Spring Boot utilizando o novo **`JdbcClient`** do Spring 6.1, junto com o **`JdbcTemplate`** para chamar stored procedures.

## Pré-requisitos

- **Java 21+**
- **Maven**
- **Banco de dados H2**

## Como rodar o projeto

### 1. Compilando o projeto

No diretório raiz do projeto, rode o comando Maven para compilar e gerar o pacote:

```bash
mvn clean package
```

### 2. Executando o projeto

Após compilar, execute o projeto com o comando Maven:

```bash
mvn spring-boot:run
```

A aplicação estará rodando em `http://localhost:8080`.

## Testando os Endpoints com HTTP Client

Você pode testar os endpoints diretamente usando um arquivo `.http`. O arquivo `.http` já está configurado para fazer chamadas HTTP de teste.

### Exemplo de uso do arquivo `.http`

1. **Localização do arquivo:** `src/test/resources/http/transactions.http`
2. **Ferramentas recomendadas:**
   - **VS Code** (com a extensão [REST Client](https://marketplace.visualstudio.com/items?itemName=humao.rest-client))
   - **IntelliJ IDEA** (que já possui suporte nativo para arquivos `.http`)

### Passos para testar:

1. Abra o arquivo `.http` em sua IDE (VS Code ou IntelliJ).
2. Execute as requisições diretamente, como `GET` para listar todas as transações ou `POST` para criar novas transações.

#### Exemplo de requisição `.http`:

```http
### Listar todas as transações
GET http://localhost:8080/api/transactions

### Criar uma nova transação (CREDIT)
POST http://localhost:8080/api/transactions
Content-Type: application/json

{
  "accountId": 1,
  "transactionType": "CREDIT",
  "amount": 200.0
}

### Criar uma nova transação (DEBIT)
POST http://localhost:8080/api/transactions
Content-Type: application/json

{
  "accountId": 1,
  "transactionType": "DEBIT",
  "amount": 50.0
}
```

---