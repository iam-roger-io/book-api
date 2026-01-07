package com.redhat.consulting.brazil.bookapi.book.dto;

import java.time.LocalDate;

public record BookResponse(
    Long id,
    String title,
    String author,
    String isbn,
    LocalDate publishedDate,
    String publisher
) {}
