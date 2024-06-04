<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/styles.css"/>
    <title>Реєстрація</title>
</head>
<body>
<div class="container">
    <h2>Реєстрація акаунту</h2>
    <form action="registration" method="post">
        <div class="form-group">
            <label for="username">Логін:</label>
            <input type="text" id="username" name="username" required>
        </div>
        <div class="form-group">
            <label for="password">Пароль:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <span class="error">${errorMessage}</span><br>
        <span class="message">${successMessage}</span><br>
        <div class="buttons_2type">
            <button type="submit" id="login">Зареєструватися</button>
        </div>
    </form>
    <a href="login.jsp" class="back-link">Вхід</a>
    <a href="booksView.jsp" class="back-link">Повернутися до каталогу</a>
</div>
</body>
</html>
