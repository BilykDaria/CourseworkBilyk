package com.coursework1.Controller;

import com.coursework1.DAOs.GuestsDAO;
import com.coursework1.Models.Guest;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/changePassword")
public class ChangePasswordServlet extends HttpServlet {

    private GuestsDAO guestsDataBase;

    @Override
    public void init() {
        guestsDataBase = (GuestsDAO) getServletContext().getAttribute("guestsDataBase");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Guest user = (Guest) request.getSession().getAttribute("user");

        if (user == null) {
            System.out.println("user is null");
        }

        if (user != null) {

            String newPassword = request.getParameter("newPassword");

            if (newPassword != null && !newPassword.isEmpty() && !guestsDataBase.isRegisteredUser(user.getLogin())) {
                user.setPassword(newPassword);
                request.getSession().setAttribute("user", user);
                request.setAttribute("passwordMessage", "Пароль успішно змінений");

            } else {
                if (newPassword == null) {
                    request.setAttribute("passwordError", "Ви не ввели новий пароль");
                }
            }
            request.getRequestDispatcher("editGuest.jsp").forward(request, response);

        } else {
            response.sendError(500, "Об'єкт користувача нульовий");
        }
    }
}