<%@ page import="com.coursework1.DAOs.BooksDAO" %>
<%@ page import="com.coursework1.Models.Author" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <link rel="stylesheet" type="text/css" href="css/stylesMain.css"/>
  <title>Створення книги</title>
</head>
<body>
<h1>Створення книги</h1>
<form action="createBook" method="post">
  <label for="name">Назва книги:</label>
  <input type="text" id="name" name="name" required><br><br>

  <label for="authorName">Ім'я автора:</label>
  <input type="text" id="authorName" name="authorName" required><br><br>

  <label for="description">Опис книги:</label>
  <textarea id="description" name="description" required></textarea><br><br>

  <button class="buttons" type="submit">Створити книгу</button>
</form>
</body>
</html>
