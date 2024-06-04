package com.coursework1.Interface;

import com.coursework1.Models.Author;

import java.util.Map;
import java.util.UUID;

public interface IAuthorsDAO {
    Map<UUID, Author> getAuthorsDataBase();
    void setAuthorsDataBase(Map<UUID, Author> authorsDataBase);
    Author getAuthorByName(String name);
    Author getAuthorById(UUID id);
    Author addAuthor(String name, String biography, String country, int age);
    boolean isAuthorInDataBase(String name);
    void deleteAuthor(UUID authorId);
}
