package com.coursework1.DAOs;

import com.coursework1.Interface.IBooksDAO;
import com.coursework1.Models.Author;
import com.coursework1.Models.Book;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class BooksDAO implements IBooksDAO {
    private HashMap<UUID, Book> booksDataBase = new HashMap<>();

    @Override
    public Map<UUID, Book> getBooksDataBase() {
        return booksDataBase;
    }

    @Override
    public void setBooksDataBase(HashMap<UUID, Book> booksDataBase) {
        this.booksDataBase = booksDataBase;
    }

    @Override
    public Book getBookById(UUID id) {
        return booksDataBase.get(id);
    }

    @Override
    public void addBook(String name, Author author, String description) {
        Book book = new Book(name, author, description);
        author.addAuthorBook(book);
        booksDataBase.put(book.getBookId(), book);
    }

    @Override
    public Book getBookByName(String name) {
        for (Book book : booksDataBase.values()) {
            if (book.getName().equalsIgnoreCase(name)) {
                return book;
            }
        }
        return null;
    }

    @Override
    public boolean isBookInDataBase(String name) {
        for (Book book : booksDataBase.values()) {
            if (book.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void deleteBookById(UUID bookId) {
        booksDataBase.remove(bookId);
    }

    @Override

    public List<Book> searchBooksByKeyword(String keyword) {
        List<Book> filteredBooks = booksDataBase.values().stream()
                .filter(book -> book.getName().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());

        if (filteredBooks.isEmpty()) {
            filteredBooks = booksDataBase.values().stream()
                    .filter(book -> book.getAuthor().getName().toLowerCase().contains(keyword.toLowerCase()))
                    .collect(Collectors.toList());
        }

        return filteredBooks;
    }
}
