package com.coursework1.Controller;

import com.coursework1.DAOs.AuthorsDAO;
import com.coursework1.Models.Author;
import com.coursework1.Models.Guest;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;


@WebServlet("/addToFavoriteAuthors")
public class AddToFavoritesAuthorServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {


        String id = request.getParameter("authorId");
        UUID authorId = UUID.fromString(id);
        AuthorsDAO authorsDataBase = (AuthorsDAO) getServletContext().getAttribute("authorsDataBase");
        Author author = authorsDataBase.getAuthorById(authorId);

        Guest user = (Guest) request.getSession().getAttribute("user");

        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        if (author != null) user.addLikedAuthor(author);
        else response.sendError(501, "Дані про автора відсутні");

        response.sendRedirect("account.jsp");
    }
}