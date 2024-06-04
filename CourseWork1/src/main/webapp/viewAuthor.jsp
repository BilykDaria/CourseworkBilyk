<%@ page import="java.util.UUID" %>
<%@ page import="com.coursework1.Models.Author" %>
<%@ page import="com.coursework1.DAOs.AuthorsDAO" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/stylesMain.css"/>
    <title>Деталі про автора</title>
</head>
<body>
<%
    String authorIdStr = request.getParameter("authorId");
    UUID authorId = UUID.fromString(authorIdStr);
    AuthorsDAO authorsDataBase = (AuthorsDAO) request.getServletContext().getAttribute("authorsDataBase");
    Author author = authorsDataBase.getAuthorById(authorId);
    if (author == null) {
        response.sendError(500, "Автор відсутній");
        return;
    }

    request.setAttribute("author", author);
%>
<h1>Деталі про автора</h1>
<c:if test="${not empty author}">
    <p><strong>Ім'я:</strong> ${author.name}</p>
    <p><strong>Біографія:</strong> ${author.biography}</p>
    <p><strong>Країна:</strong> ${author.country}</p>
    <p><strong>Вік:</strong> ${author.age}</p>
    <h2>Книги, написані автором:</h2>
    <ul>
        <c:forEach var="book" items="${author.writtenBooks}">
            <li>${book.name}</li>
        </c:forEach>
    </ul>
</c:if>
<c:if test="${empty author}">
    <p>Автор не знайдений</p>
</c:if>
<c:if test="${user.role == 'ADMIN'}">
    <form action="editAuthor.jsp" method="get">
        <input type="hidden" name="authorId" value="${author.id}"/>
        <button class="buttons" type="submit">Редагувати інформацію про автора</button>
    </form>
</c:if>
<form action="addToFavoriteAuthors" method="post">
    <input type="hidden" name="authorId" value="${author.id}"/>
    <button class="buttons" type="submit">Додати автора до обраних</button>
</form>
</body>
</html>
