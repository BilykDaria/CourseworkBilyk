package com.coursework1.Controller;

import com.coursework1.DAOs.AuthorsDAO;

import com.coursework1.DAOs.BooksDAO;
import com.coursework1.Models.Book;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;
import java.util.UUID;

@WebServlet("/deleteAuthor")
public class DeleteAuthorServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID authorId = UUID.fromString(request.getParameter("authorId"));

        AuthorsDAO authorsDAO = (AuthorsDAO) getServletContext().getAttribute("authorsDataBase");
        Set<Book> books = authorsDAO.getAuthorById(authorId).getWrittenBooks();
        BooksDAO booksDataBase = (BooksDAO) getServletContext().getAttribute("booksDataBase");

        for (Book book : books) {
            booksDataBase.deleteBookById(book.getBookId());
        }

        authorsDAO.deleteAuthor(authorId);

        response.sendRedirect("booksView.jsp");
    }
}
