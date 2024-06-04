package com.coursework1.Controller;

import com.coursework1.DAOs.GuestsDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    private GuestsDAO guestsDataBase;

    @Override
    public void init() {
        guestsDataBase = (GuestsDAO) getServletContext().getAttribute("guestsDataBase");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");


        if (guestsDataBase.isRegisteredUser(username)) {
            request.setAttribute("errorMessage", "Користувач з таким логіном зареєстрований");
            request.getRequestDispatcher("registration.jsp").forward(request, response);
        } else {
            guestsDataBase.createUser(username, password);
            request.setAttribute("successMessage", "Ви успішно зареєструвалися");
            request.getRequestDispatcher("registration.jsp").forward(request, response);
        }
    }
}
