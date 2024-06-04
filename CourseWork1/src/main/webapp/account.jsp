<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/stylesMain.css"/>
    <title>Акаунт користувача</title>
    <style>
    table {
    width: 100%;
    border-collapse: collapse;
    }
    table th, table td {
    padding: 12px;
    border: 1px solid #000;
    text-align: left;
    }</style>
</head>
<body>

<h1>Акаунт користувача: ${user.login}</h1>

<a href="editGuest.jsp" class="links">Редагувати акаунт</a> | <a class="links" href="booksView.jsp">Повернутись до каталогу</a>

<c:if test="${user.role == 'ADMIN'}">
    <form action="createBook.jsp" method="get">
        <button class="buttons" type="submit">Додати книгу</button>
    </form>
</c:if>
<c:if test="${user.role == 'ADMIN'}">
    <form action="createAuthor.jsp" method="get">
        <button class="buttons" type="submit">Додати автора</button>
    </form>
</c:if>
<h2>Вподобані книги</h2>
<table border="1">
    <tr>
        <th>Назва книги</th>
        <th>Автор</th>
        <th>Опис</th>
        <th>Дії</th>
    </tr>
    <c:forEach var="book" items="${user.likedBooks}">
        <tr>
            <td>${book.name}</td>
            <td>${book.author.name}</td>
            <td>${book.description}</td>
            <td>
                <c:if test="${user.role == 'ADMIN'}">
                    <form action="editBook.jsp" method="get" style="display:inline;">
                        <input type="hidden" name="bookId" value="${book.bookId}"/>
                        <button class="buttons" type="submit">Редагувати книгу</button>
                    </form>
                </c:if>
                <form action="removeFromFavorites" method="post" style="display:inline;">
                    <input type="hidden" name="bookId" value="${book.bookId}"/>
                    <button class="buttons" type="submit">Видалити з обраних</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<h2>Вподобані автори</h2>
<table border="1">
    <tr>
        <th>Ім'я автора</th>
        <th>Біографія</th>
        <th>Країна</th>
        <th>Дії</th>
    </tr>
    <c:forEach var="author" items="${user.likedAuthors}">
        <tr>
            <td>${author.name}</td>
            <td>${author.biography}</td>
            <td>${author.country}</td>
            <td>
                <form action="removeAuthorFromFavorites" method="post" style="display:inline;">
                    <input type="hidden" name="authorId" value="${author.id}"/>
                    <button class="buttons" type="submit">Видалити з обраних</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
