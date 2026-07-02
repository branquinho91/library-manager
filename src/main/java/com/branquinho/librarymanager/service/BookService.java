package com.branquinho.librarymanager.service;

import java.util.List;

import com.branquinho.librarymanager.dao.BookDAO;
import com.branquinho.librarymanager.exception.BookNotFoundException;
import com.branquinho.librarymanager.model.Book;

public class BookService {
    private final BookDAO bookDAO = new BookDAO();

    // Commands
    public void registerBook(Book book) {
        bookDAO.save(book);
    }

    public void removeBook(Long id) {
        Book book = this.findBookById(id);
        bookDAO.remove(book);
    }

    public void borrowBook(Long id) {
        Book book = this.findBookById(id);
        book.borrow();
        bookDAO.update(book);
    }

    public void returnBook(Long id) {
        Book book = this.findBookById(id);
        book.returnBook();
        bookDAO.update(book);
    }

    // Queries
    public Book findBookById(Long id) {
        Book book = bookDAO.findById(id);

        if (book == null) {
            throw new BookNotFoundException();
        }

        return book;
    }

    public List<Book> listBooks() {
        return bookDAO.findAll();
    }
}
