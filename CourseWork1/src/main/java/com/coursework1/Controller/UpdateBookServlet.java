package com.coursework1.Controller;

import com.coursework1.DAOs.AuthorsDAO;
import com.coursework1.DAOs.BooksDAO;
import com.coursework1.Models.Book;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/updateBook")
public class UpdateBookServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("bookId");
        UUID bookId = UUID.fromString(id);
        BooksDAO booksDataBase = (BooksDAO) request.getServletContext().getAttribute("booksDataBase");
        Book book = booksDataBase.getBookById(bookId);
        String newName = request.getParameter("name");
        String newAuthorName = request.getParameter("author");
        String newDescription = request.getParameter("description");

        AuthorsDAO authorsDataBase = (AuthorsDAO) getServletContext().getAttribute("authorsDataBase");

        if (newName.isEmpty() || newAuthorName.isEmpty() || newDescription.isEmpty()) {
            response.sendError(500, "Введіть значення в поля");
        }

        if (authorsDataBase.getAuthorByName(newAuthorName) == null) {
            response.sendError(400, "Автор не знайдений");
            return;
        }

        if (book != null) {
            book.setName(newName);
            book.setAuthor(authorsDataBase.getAuthorByName(newAuthorName));
            book.setDescription(newDescription);
        }

        response.sendRedirect("account.jsp");
    }
}
