package com.coursework1.Controller;

import com.coursework1.DAOs.BooksDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/deleteBook")
public class DeleteBookServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID bookId = UUID.fromString(request.getParameter("bookId"));
        BooksDAO booksDAO = (BooksDAO) getServletContext().getAttribute("booksDataBase");

        booksDAO.getBooksDataBase().remove(bookId);

        response.sendRedirect("booksView.jsp");
    }
}
