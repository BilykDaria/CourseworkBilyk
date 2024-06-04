package com.coursework1.Controller;

import com.coursework1.DAOs.GuestsDAO;
import com.coursework1.Models.Book;
import com.coursework1.Models.Guest;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/removeFromFavorites")
public class RemoveLikedBookServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Guest currentUser = (Guest) request.getSession().getAttribute("user");

        if (currentUser == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        UUID bookId = UUID.fromString(request.getParameter("bookId"));

        Book bookToRemove = null;
        for (Book book : currentUser.getLikedBooks()) {
            if (book.getBookId().equals(bookId)) {
                bookToRemove = book;
                break;
            }
        }

        if (bookToRemove != null) {
            currentUser.deleteGuestLikedBook(bookToRemove);
        }

        GuestsDAO guestsDAO = (GuestsDAO) getServletContext().getAttribute("guestsDataBase");
        guestsDAO.setUsersDataBase(guestsDAO.getUsersDataBase());

        response.sendRedirect("account.jsp");
    }
}
