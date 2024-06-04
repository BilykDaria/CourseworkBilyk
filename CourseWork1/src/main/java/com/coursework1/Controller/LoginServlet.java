package com.coursework1.Controller;

import com.coursework1.DAOs.GuestsDAO;
import com.coursework1.Models.Guest;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private GuestsDAO guestsDataBase;

    @Override
    public void init() {
        guestsDataBase = (GuestsDAO) getServletContext().getAttribute("guestsDataBase");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (guestsDataBase.isRegisteredUser(username)) {
            Guest user = guestsDataBase.findByLogin(username);

            if (user != null && user.getPassword().equals(password)) {
                request.getSession().setAttribute("user", user);
                response.sendRedirect("booksView.jsp");

            } else {
                request.setAttribute("errorMessage", "Неправильний логін або пароль");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("errorMessage", "Користувача з таким логіном не знайдено");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
