package com.branquinho.librarymanager.model;

import com.branquinho.librarymanager.exception.BookAlreadyBorrowedException;
import com.branquinho.librarymanager.exception.BookAlreadyReturnedException;

public class Book {
    // Properties
    private Long id;
    private String title;
    private String author;
    private String genre;
    private int pageCount;
    private int publicationYear;
    private boolean available;

    // Constructor
    public Book(
            Long id,
            String title,
            String author,
            String genre,
            int pageCount,
            int publicationYear,
            boolean available
    ) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.pageCount = pageCount;
        this.publicationYear = publicationYear;
        this.available = available;
    }

    public Book(
            String title,
            String author,
            String genre,
            int pageCount,
            int publicationYear
    ) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.pageCount = pageCount;
        this.publicationYear = publicationYear;
        this.available = true;
    }

    // Getters
    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getGenre() {
        return this.genre;
    }

    public int getPageCount() {
        return this.pageCount;
    }

    public int getPublicationYear() {
        return this.publicationYear;
    }

    public boolean isAvailable() {
        return this.available;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    // Methods
    public void borrow() {
        if (!isAvailable()) {
            throw new BookAlreadyBorrowedException();
        }
        this.available = false;
    }

    public void returnBook() {
        if (isAvailable()) {
            throw new BookAlreadyReturnedException();
        }
        this.available = true;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + getId() + ", " +
                "title='" + getTitle() + "', " +
                "author='" + getAuthor() + "', " +
                "genre='" + getGenre() + "', " +
                "pageCount=" + getPageCount() + ", " +
                "publicationYear=" + getPublicationYear() + ", " +
                "available=" + isAvailable() + "}";
    }
}
