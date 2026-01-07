package com.redhat.consulting.brazil.bookapi.book.dto;

import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public record BookUpdateRequest(
    @Size(max = 200) String title,
    @Size(max = 120) String author,
    @Size(max = 40) String isbn,
    LocalDate publishedDate,
    @Size(max = 80) String publisher
) {}
