<%@ page import="com.coursework1.DAOs.BooksDAO" %>
<%@ page import="com.coursework1.Models.Book" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.UUID" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/stylesMain.css"/>
    <title>Каталог книг</title>
    <style>
    table {
        width: 100%;
        border-collapse: collapse;
    }
    table th, table td {
        padding: 12px;
        border: 1px solid #000;
        text-align: left;
    }
    input {
        padding: 8px 10px;
        font-size: 16px;
        border: 1px solid #d7ccc8;
        border-radius: 15px;
        background-color: #efebe9;
        color: #4e342e;
    }
</style>
</head>
<body>
<%
    BooksDAO booksDAO = (BooksDAO) request.getServletContext().getAttribute("booksDataBase");
    Map<UUID, Book> booksDataBase = booksDAO.getBooksDataBase();
    request.setAttribute("books", booksDataBase);
%>

<c:choose>
    <c:when test="${user != null}">
        <a href="account.jsp" class="links">Перейти на сторінку користувача</a>
    </c:when>
    <c:otherwise>
        <a href="login.jsp" class="links">Логін</a>
    </c:otherwise>
</c:choose>

<form action="searchBooks" method="get">
    <label for="keyword">Ключове слово:</label>
    <input type="text" id="keyword" name="keyword" required>
    <button class="buttons" type="submit">Пошук</button>
</form>

<h1>Каталог книг</h1>
<table border="1">
    <c:choose>
        <c:when test="${empty books}">
            <h2>Каталог поки пустий...</h2>
        </c:when>
        <c:otherwise>
            <tr>
                <th>Назва книги</th>
                <th>Автор</th>
                <th>Опис</th>
                <th>Дії</th>
            </tr>
            <c:forEach var="book" items="${books}">
                <tr>
                    <td>${book.value.name}</td>
                    <td>${book.value.author.name}</td>
                    <td>${book.value.description}</td>
                    <td>
                        <form action="viewAuthor.jsp" method="post">
                            <input type="hidden" name="authorId" value="${book.value.author.id}"/>
                            <button class="buttons" type="submit">Деталі про автора</button>
                        </form>
                        <form action="addToFavorites" method="post">
                            <input type="hidden" name="bookId" value="${book.key}"/>
                            <button class="buttons" type="submit">Додати до обраних</button>
                        </form>
                        <c:if test="${user.role == 'ADMIN'}">
                            <form action="editBook.jsp" method="get">
                                <input type="hidden" name="bookId" value="${book.key}"/>
                                <button class="buttons" type="submit">Редагувати інформацію про книгу</button>
                            </form>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </c:otherwise>
    </c:choose>
</table>
</body>
</html>

