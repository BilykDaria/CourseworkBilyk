package com.coursework1.Controller;

import com.coursework1.DAOs.AuthorsDAO;
import com.coursework1.DAOs.BooksDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/createBook")
public class CreateBookServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String authorName = request.getParameter("authorName");
        String description = request.getParameter("description");


        BooksDAO booksDataBase = (BooksDAO) getServletContext().getAttribute("booksDataBase");

        if (booksDataBase.isBookInDataBase(name)) {
            response.sendError(400, "Книга з такою назвою вже існує");
            return;
        }

        AuthorsDAO authorsDataBase = (AuthorsDAO) getServletContext().getAttribute("authorsDataBase");
        if (authorsDataBase.isAuthorInDataBase(authorName)) {
            booksDataBase.addBook(name, authorsDataBase.getAuthorByName(authorName), description);
        } else response.sendRedirect("createAuthor.jsp");

        response.sendRedirect("booksView.jsp");
    }
}
