package com.coursework1.Controller;

import com.coursework1.DAOs.AuthorsDAO;
import com.coursework1.Models.Author;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/updateAuthor")
public class UpdateAuthorServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID authorId = UUID.fromString(request.getParameter("authorId"));
        String name = request.getParameter("name");
        String biography = request.getParameter("biography");
        String country = request.getParameter("country");
        int age = Integer.parseInt(request.getParameter("age"));

        AuthorsDAO authorsDAO = (AuthorsDAO) getServletContext().getAttribute("authorsDataBase");

        Author author = authorsDAO.getAuthorById(authorId);
        if (author != null) {
            author.setName(name);
            author.setBiography(biography);
            author.setCountry(country);
            author.setAge(age);

        } else response.sendError(500, "Автора не знайдено");

        request.getRequestDispatcher("viewAuthor.jsp").forward (request, response);
    }
}
