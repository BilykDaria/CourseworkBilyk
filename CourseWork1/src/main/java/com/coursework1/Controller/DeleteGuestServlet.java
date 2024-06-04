package com.coursework1.Controller;

import com.coursework1.DAOs.GuestsDAO;
import com.coursework1.Models.Guest;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteGuest")
public class DeleteGuestServlet extends HttpServlet {

    private GuestsDAO guestsDataBase;

    @Override
    public void init() {
        guestsDataBase = (GuestsDAO) getServletContext().getAttribute("guestsDataBase");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        Guest user = (Guest) request.getSession().getAttribute("user");


        if (user != null && guestsDataBase.isRegisteredUser(user.getLogin())) {

            guestsDataBase.deleteUser(user);
            request.getSession().invalidate();
            response.sendRedirect("booksView.jsp");

        } else {
            response.sendError(500, "Помилка при видаленні акаунту");
        }
    }
}