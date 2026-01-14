# book-api (Java 21 + Spring Boot + OpenAPI)

## Run local
```bash
mvn -DskipTests spring-boot:run
```

## Swagger UI
- http://localhost:8080/swagger-ui/index.html

## OpenAPI
- http://localhost:8080/v3/api-docs
- http://localhost:8080/v3/api-docs.yaml


## Chamadas para teste

### Adicionar um livro
``` 
curl -X POST http://localhost:8080/api/books \
  -H "Content-Type: application/json" \
  -d '{
    "title": "A Arte Da Guerra",
    "author": "Robert C. Martin",
    "isbn": "9780132350884",
    "publisher": "Prentice Hall",
    "publishedDate": "2008-08-01"
  }'
```

### Consultar livros
```
curl -X GET http://localhost:8080/api/books
``
