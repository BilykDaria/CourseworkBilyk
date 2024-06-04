<%@ page import="com.coursework1.DAOs.AuthorsDAO" %>
<%@ page import="com.coursework1.Models.Author" %>
<%@ page import="java.util.UUID" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/stylesMain.css"/>
    <title>Редагування автора</title>
    <style>
        textarea{
            width: 30%;
            height: 100px;
            background-color: #ecdde9;
        }
    </style>
</head>
<body>
<%
    UUID authorId = UUID.fromString(request.getParameter("authorId"));
    AuthorsDAO authorsDAO = (AuthorsDAO) request.getServletContext().getAttribute("authorsDataBase");
    Author author = authorsDAO.getAuthorById(authorId);

    if (author == null) {
        response.sendError(500, "Автор не знайдений");
        return;
    }

    request.setAttribute("author", author);
%>

<h1>Редагування автора: ${author.name}</h1>

<form action="updateAuthor" method="post">
    <input type="hidden" name="authorId" value="${author.id}"/>
    <label for="name">Ім'я:</label>
    <input type="text" id="name" name="name" value="${author.name}" required/>
    <br/>
    <label for="biography">Біографія:</label>
    <textarea id="biography" name="biography" required>${author.biography}</textarea>
    <br/>
    <label for="country">Країна:</label>
    <input type="text" id="country" name="country" value="${author.country}" required/>
    <br/>
    <label for="age">Вік:</label>
    <input type="number" id="age" name="age" value="${author.age}" required/>
    <br/>
    <button class="buttons" type="submit">Оновити</button>
</form>

<form action="deleteAuthor" method="post">
    <input type="hidden" name="authorId" value="${author.id}"/>
    <button class="buttons" type="submit">Видалити автора</button>
</form>

<a class="links" href="booksView.jsp">Назад до каталогу</a>
<br>
<a class="links" href="account.jsp">Назад до акаунту</a>

</body>
</html>
