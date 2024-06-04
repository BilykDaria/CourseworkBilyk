package com.coursework1.Controller;

import com.coursework1.DAOs.BooksDAO;
import com.coursework1.Models.Book;
import com.coursework1.Models.Guest;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;


@WebServlet("/addToFavorites")
public class AddToFavoritesBooksServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String id = request.getParameter("bookId");
        UUID bookId = UUID.fromString(id);
        BooksDAO booksDataBase = (BooksDAO) getServletContext().getAttribute("booksDataBase");
        Book book = booksDataBase.getBookById(bookId);
        Guest user = (Guest) request.getSession().getAttribute("user");

        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        if (book != null) {
            user.addLikedBook(book);
        } else response.sendError(501, "Дані про книгу відсутні");

        response.sendRedirect("account.jsp");
    }
}
