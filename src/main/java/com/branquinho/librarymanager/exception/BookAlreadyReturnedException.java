package com.branquinho.librarymanager.exception;

public class BookAlreadyReturnedException extends RuntimeException {
    public BookAlreadyReturnedException() {
        super("Book is already returned!");
    }
}
