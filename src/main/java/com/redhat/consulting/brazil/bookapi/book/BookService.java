package com.redhat.consulting.brazil.bookapi.book;

import com.redhat.consulting.brazil.bookapi.book.dto.BookCreateRequest;
import com.redhat.consulting.brazil.bookapi.book.dto.BookUpdateRequest;
import com.redhat.consulting.brazil.bookapi.book.exception.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {

  private final BookRepository repo;

  public BookService(BookRepository repo) {
    this.repo = repo;
  }

  public List<Book> list() {
    return repo.findAll();
  }

  public Book get(Long id) {
    return repo.findById(id)
        .orElseThrow(() -> new NotFoundException("Book id=%d not found".formatted(id)));
  }

  @Transactional
  public Book create(BookCreateRequest req) {
    var b = new Book();
    b.setTitle(req.title());
    b.setAuthor(req.author());
    b.setIsbn(req.isbn());
    b.setPublishedDate(req.publishedDate());
    b.setPublisher(req.publisher());
    return repo.save(b);
  }

  @Transactional
  public Book update(Long id, BookUpdateRequest req) {
    var b = get(id);

    if (req.title() != null) b.setTitle(req.title());
    if (req.author() != null) b.setAuthor(req.author());
    if (req.isbn() != null) b.setIsbn(req.isbn());
    if (req.publishedDate() != null) b.setPublishedDate(req.publishedDate());
    if (req.publisher() != null) b.setPublisher(req.publisher());

    return repo.save(b);
  }

  @Transactional
  public void delete(Long id) {
    if (!repo.existsById(id)) {
      throw new NotFoundException("Book id=%d not found".formatted(id));
    }
    repo.deleteById(id);
  }
}
