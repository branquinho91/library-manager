package com.branquinho.librarymanager.exception;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException() {
        super("Book is not found!");
    }
}