<%@ page import="com.coursework1.Models.Book" %>
<%@ page import="java.util.UUID" %>
<%@ page import="com.coursework1.DAOs.BooksDAO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/stylesMain.css"/>
    <title>Редагування книги</title>
</head>
<style>
    textarea{
        width: 30%;
        height: 100px;
        background-color: #ecdde9;
    }
</style>
<body>
<%
    String id = request.getParameter("bookId");
    UUID bookId = UUID.fromString(id);
    BooksDAO booksDataBase = (BooksDAO) request.getServletContext().getAttribute("booksDataBase");
    Book book = booksDataBase.getBookById(bookId);

    if (book == null) {
        response.sendError(500, "Книгу не знайдено");
        return;
    }

    request.setAttribute("book", book);
%>

<h1>Редагування книги: ${book.name}</h1>

<form action="updateBook" method="post">
    <input type="hidden" name="bookId" value="${book.bookId}"/>
    <label for="name">Назва:</label>
    <input type="text" id="name" name="name" value="${book.name}" required/>
    <br/>
    <label for="author">Автор:</label>
    <input type="text" id="author" name="author" value="${book.author.name}" required/>
    <br/>
    <label for="description">Опис:</label>
    <textarea id="description" name="description" required>${book.description}</textarea>
    <br/>
    <button class="buttons" type="submit">Оновити</button>
</form>

<form action="deleteBook" method="post">
    <input type="hidden" name="bookId" value="${book.bookId}"/>
    <button class="buttons" type="submit">Видалити книгу</button>
</form>

<a class="links" href="account.jsp">Назад до акаунту</a>

</body>
</html>
