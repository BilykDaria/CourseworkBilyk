<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/styles.css"/>
    <title>Вхід до акаунту</title>
</head>
<body>
<div class="container">
    <h2>Вхід до бібліотечного акаунту</h2>
    <form action="login" method="post">
        <div class="form-group">
            <label for="username">Логін:</label>
            <input type="text" id="username" name="username" required>
        </div>
        <div class="form-group">
            <label for="password">Пароль:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <span class="error">${errorMessage}</span><br>
        <div class="buttons">
            <button type="submit" class="login-btn"  id="login">Вхід</button>
            <button type="button" class="register-btn" onclick="window.location.href='registration.jsp'">Реєстрація</button>
        </div>
    </form>
    <a href="booksView.jsp" class="back-link">Повернутися до каталогу</a>
</div>
</body>
</html>


