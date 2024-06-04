package com.coursework1.Controller;

import com.coursework1.DAOs.AuthorsDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/createAuthor")
public class CreateAuthorServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String biography = request.getParameter("biography");
        String country = request.getParameter("country");
        int age = Integer.parseInt(request.getParameter("age"));

        AuthorsDAO authorsDataBase = (AuthorsDAO) getServletContext().getAttribute("authorsDataBase");
        if (authorsDataBase == null) {
            authorsDataBase = new AuthorsDAO();
            getServletContext().setAttribute("authorsDataBase", authorsDataBase);
        }

        if (authorsDataBase.isAuthorInDataBase(name)) {
            response.sendError(400, "Автор з таким іменем вже існує");
            return;
        }

        authorsDataBase.addAuthor(name, biography, country, age);

        response.sendRedirect("booksView.jsp");
    }
}
