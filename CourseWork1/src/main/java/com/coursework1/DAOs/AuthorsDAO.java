package com.coursework1.DAOs;

import com.coursework1.Interface.IAuthorsDAO;
import com.coursework1.Models.Author;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AuthorsDAO implements IAuthorsDAO {
    private Map<UUID, Author> authorsDataBase = new HashMap<>();

    @Override
    public Map<UUID, Author> getAuthorsDataBase() {
        return authorsDataBase;
    }

    @Override
    public void setAuthorsDataBase(Map<UUID, Author> authorsDataBase) {
        this.authorsDataBase = authorsDataBase;
    }

    @Override
    public Author getAuthorByName(String name) {
        for (Author author : authorsDataBase.values()) {
            if (author.getName().equalsIgnoreCase(name)) {
                return author;
            }
        }
        return null;
    }

    @Override
    public Author getAuthorById(UUID id) {
        return authorsDataBase.get(id);
    }

    @Override
    public Author addAuthor(String name, String biography, String country, int age) {
        Author author = new Author(name, biography, country, age);
        authorsDataBase.put(author.getId(), author);
        return author;
    }

    @Override
    public boolean isAuthorInDataBase(String name) {
        for (Author author : authorsDataBase.values()) {
            if (author.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void deleteAuthor(UUID authorId) {
        authorsDataBase.remove(authorId);
    }
}
