package com.redhat.consulting.brazil.bookapi.book.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public record BookCreateRequest(
    @NotBlank @Size(max = 200) String title,
    @NotBlank @Size(max = 120) String author,
    @Size(max = 40) String isbn,
    LocalDate publishedDate,
    @Size(max = 80) String publisher
) {}
