<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/stylesMain.css"/>
    <title>Результати пошуку</title>
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
</style>
</head>
<body>
<h1>Результати пошуку</h1>
<c:choose>
    <c:when test="${empty searchResults}">
        <h2>Жодна книга не знайдена</h2>
    </c:when>
    <c:otherwise>
        <table border="1">
            <tr>
                <th>Назва книги</th>
                <th>Автор</th>
                <th>Опис</th>
            </tr>
            <c:forEach var="book" items="${searchResults}">
                <tr>
                    <td>${book.name}</td>
                    <td>${book.author.name}</td>
                    <td>${book.description}</td>
                </tr>
            </c:forEach>
        </table>
    </c:otherwise>
</c:choose>

<a href="booksView.jsp" class="links">Повернутися до каталогу</a>
</body>
</html>
