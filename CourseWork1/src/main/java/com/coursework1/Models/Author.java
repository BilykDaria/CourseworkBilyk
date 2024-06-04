package com.coursework1.Models;

import java.util.*;

public class Author {
    private UUID id;
    private String name;
    private String biography;
    private String country;
    private int age;
    private TreeSet<Book> writtenBooks;

    public Author(String name, String biography, String country, int age) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.biography = biography;
        this.country = country;
        this.age = age;
        this.writtenBooks = new TreeSet<>(Comparator.comparing(Book::getName));
    }

    public Set<Book> getWrittenBooks() {
        return writtenBooks;
    }

    public void setWrittenBooks(TreeSet<Book> writtenBooks) {
        this.writtenBooks = writtenBooks;
    }

    public void addAuthorBook(Book book) {
        writtenBooks.add(book);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
