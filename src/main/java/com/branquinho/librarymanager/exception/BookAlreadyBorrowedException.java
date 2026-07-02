package com.branquinho.librarymanager.exception;

public class BookAlreadyBorrowedException extends RuntimeException {
    public BookAlreadyBorrowedException() {
        super("Book is already borrowed!");
    }
}
