# ShortLink

API simples para encurtar URLs usando Spring Boot, Java 21 e PostgreSQL.

## Requisitos

- Java 21
- PostgreSQL
- Banco de dados `desafio_shorturl`

Defina as variáveis de ambiente `DB_USER` e `DB_PASSWORD` com as credenciais do PostgreSQL antes de iniciar a aplicação.

## Executar

No PowerShell:
 
```powershell
$env:DB_USER = "seu_usuario"
$env:DB_PASSWORD = "sua_senha"
.\mvnw.cmd spring-boot:run
```

A aplicação inicia, por padrão, em `http://localhost:8080`.

## Endpoints

### Criar link curto

`POST /shortlink`

Corpo JSON:

```json
{
  "urlOriginal": "https://example.com"
}
```

A resposta inclui o link curto e os dados do registro.

### Redirecionar

Acesse `GET /r/{urlEncurtada}` para redirecionar para a URL original.
