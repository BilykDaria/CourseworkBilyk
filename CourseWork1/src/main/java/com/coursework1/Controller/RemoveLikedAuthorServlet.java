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

@WebServlet("/removeAuthorFromFavorites")
public class RemoveLikedAuthorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Guest user = (Guest) request.getSession().getAttribute("user");
        UUID authorId = UUID.fromString(request.getParameter("authorId"));
        AuthorsDAO authorDataBase = (AuthorsDAO) request.getServletContext().getAttribute("authorsDataBase");
        Author author = authorDataBase.getAuthorById(authorId);

        if (author == null || authorDataBase.getAuthorById(author.getId()) == null) {
            response.sendError(501, "Автора не знайдено");
            return;
        }

        user.getLikedAuthors().remove(author);
        response.sendRedirect("account.jsp");
    }
}
