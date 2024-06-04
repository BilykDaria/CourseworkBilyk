package com.coursework1.Controller;

import com.coursework1.DAOs.BooksDAO;
import com.coursework1.Models.Book;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/searchBooks")
public class SearchBooksServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = request.getParameter("keyword");

        BooksDAO booksDataBase = (BooksDAO) getServletContext().getAttribute("booksDataBase");
        if (booksDataBase == null) {
            booksDataBase = new BooksDAO();
            getServletContext().setAttribute("booksDataBase", booksDataBase);
        }

        List<Book> searchResults = booksDataBase.searchBooksByKeyword(keyword);
        request.setAttribute("searchResults", searchResults);
        request.getRequestDispatcher("searchResults.jsp").forward(request, response);
    }
}
