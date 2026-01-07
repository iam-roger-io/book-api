package com.redhat.consulting.brazil.bookapi.book;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "books")
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 200)
  private String title;

  @Column(nullable = false, length = 120)
  private String author;

  @Column(length = 40)
  private String isbn;

  private LocalDate publishedDate;

  @Column(length = 80)
  private String publisher;

  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }

  public String getTitle() { return title; }
  public void setTitle(String title) { this.title = title; }

  public String getAuthor() { return author; }
  public void setAuthor(String author) { this.author = author; }

  public String getIsbn() { return isbn; }
  public void setIsbn(String isbn) { this.isbn = isbn; }

  public LocalDate getPublishedDate() { return publishedDate; }
  public void setPublishedDate(LocalDate publishedDate) { this.publishedDate = publishedDate; }

  public String getPublisher() { return publisher; }
  public void setPublisher(String publisher) { this.publisher = publisher; }
}
