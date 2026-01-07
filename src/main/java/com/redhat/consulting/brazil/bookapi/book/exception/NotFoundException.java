package com.redhat.consulting.brazil.bookapi.book.exception;

public class NotFoundException extends RuntimeException {
  public NotFoundException(String message) {
    super(message);
  }
}
