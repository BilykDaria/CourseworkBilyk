package com.coursework1.Models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Guest {

    private UUID id;
    private String login;
    private String password;
    private ArrayList<Book> likedBooks;
    private ArrayList<Author> likedAuthors;
    private Role role;


    public Guest(String login, String password) {
        this.id = UUID.randomUUID();
        this.login = login;
        this.password = password;
        this.likedBooks = new ArrayList<>();
        this.likedAuthors = new ArrayList<>();
        this.role = Role.GUEST;
    }

    public Guest(String login, String password, Role role) {
        this.id = UUID.randomUUID();
        this.login = login;
        this.password = password;
        this.likedBooks = new ArrayList<>();
        this.likedAuthors = new ArrayList<>();
        this.role = role;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ArrayList<Author> getLikedAuthors() {
        return likedAuthors;
    }

    public void setLikedAuthors(ArrayList<Author> likedAuthors) {
        this.likedAuthors = likedAuthors;
    }

    public void addLikedBook(Book book) {
        this.likedBooks.add(book);
    }

    public void addLikedAuthor(Author author) {
        this.likedAuthors.add(author);
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public UUID getId() {
        return id;
    }

    public List<Book> getLikedBooks() {
        return likedBooks;
    }

    public void deleteGuestLikedBook(Book book) {
        likedBooks.remove(book);
    }

    public void setLikedBooks(ArrayList<Book> likedBooks) {
        this.likedBooks = likedBooks;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public enum Role {
        ADMIN, GUEST
    }

}
