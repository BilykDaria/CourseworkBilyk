package com.coursework1.Models;

import java.util.UUID;

public class Book {
    private UUID bookId;
    private String name;
    private Author author;
    private String description;

    public Book(String name, Author author, String description) {
        this.bookId = UUID.randomUUID();
        this.name = name;
        this.author = author;
        this.description = description;
    }

    public UUID getBookId() {
        return bookId;
    }

    public void setBookId(UUID bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
