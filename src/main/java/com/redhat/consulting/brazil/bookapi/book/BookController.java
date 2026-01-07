package com.redhat.consulting.brazil.bookapi.book;

import com.redhat.consulting.brazil.bookapi.book.dto.BookCreateRequest;
import com.redhat.consulting.brazil.bookapi.book.dto.BookResponse;
import com.redhat.consulting.brazil.bookapi.book.dto.BookUpdateRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/api/books")
@Tag(name = "Books", description = "Operações de cadastro e gerenciamento de livros")
public class BookController {

  private final BookService service;

  public BookController(BookService service) {
    this.service = service;
  }

  @GetMapping
  @Operation(summary = "Listar livros", description = "Retorna a lista de todos os livros cadastrados")
  @ApiResponse(responseCode = "200", description = "Lista de livros retornada com sucesso")
  public List<BookResponse> list() {
    return service.list().stream().map(this::toResponse).toList();
  }

  @GetMapping("/{id}")
  @Operation(summary = "Consultar livro por ID", description = "Retorna os dados de um livro específico")
  @ApiResponse(responseCode = "200", description = "Livro encontrado")
  @ApiResponse(responseCode = "404", description = "Livro não encontrado")
  public BookResponse get(@PathVariable Long id) {
    return toResponse(service.get(id));
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @Operation(summary = "Cadastrar livro", description = "Cadastra um novo livro")
  @ApiResponse(responseCode = "201", description = "Livro criado com sucesso")
  @ApiResponse(responseCode = "400", description = "Dados inválidos")
  public BookResponse create(@RequestBody @Valid BookCreateRequest req) {
    return toResponse(service.create(req));
  }

  @PutMapping("/{id}")
  @Operation(summary = "Atualizar livro", description = "Atualiza os dados de um livro existente")
  @ApiResponse(responseCode = "200", description = "Livro atualizado com sucesso")
  @ApiResponse(responseCode = "404", description = "Livro não encontrado")
  public BookResponse update(@PathVariable Long id, @RequestBody @Valid BookUpdateRequest req) {
    return toResponse(service.update(id, req));
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @Operation(summary = "Excluir livro", description = "Remove um livro do cadastro")
  @ApiResponse(responseCode = "204", description = "Livro removido com sucesso")
  @ApiResponse(responseCode = "404", description = "Livro não encontrado")
  public void delete(@PathVariable Long id) {
    service.delete(id);
  }

  private BookResponse toResponse(Book b) {
    return new BookResponse(
        b.getId(),
        b.getTitle(),
        b.getAuthor(),
        b.getIsbn(),
        b.getPublishedDate(),
        b.getPublisher()
    );
  }
}
