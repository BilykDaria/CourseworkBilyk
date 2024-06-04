package com.coursework1.Interface;

import com.coursework1.Models.Author;
import com.coursework1.Models.Book;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface IBooksDAO {
    Map<UUID, Book> getBooksDataBase();
    void setBooksDataBase(HashMap<UUID, Book> booksDataBase);
    Book getBookById(UUID id);
    void addBook(String name, Author author, String description);
    Book getBookByName(String name);
    boolean isBookInDataBase(String name);
    void deleteBookById(UUID bookId);
    List<Book> searchBooksByKeyword(String keyword);
}
