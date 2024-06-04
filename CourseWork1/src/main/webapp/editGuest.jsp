<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" type="text/css" href="css/stylesMain.css"/>
  <title>Редагування акаунту</title>
</head>
<body>
<div class="container">
  <h1>Редагування акаунту</h1>

  <form action="changeLogin" method="post">
    <h3>Редагування логіна</h3>
    <label for="newUsername">Новий логін:</label>
    <input type="text" id="newUsername" name="newUsername" required>
    <span class="message">${usernameMessage}</span>
    <span class="error">${usernameError}</span>
    <button class="buttons" type="submit">Оновити логін</button>
  </form>

  <form action="changePassword" method="post">
    <h3>Редагування пароля</h3>
    <label for="newPassword">Новий пароль:</label>
    <input type="text" id="newPassword" name="newPassword" required>
    <span class="message">${passwordMessage}</span>
    <span class="error">${passwordError}</span>
    <button class="buttons" type="submit">Оновити пароль</button>
  </form>

  <h3>Дії з акаунтом</h3>
  <form action="exitGuest" method="get">
    <button class="buttons" type="submit">Вийти з акаунту</button>
  </form>
  <br>
  <form action="deleteGuest" method="get">
    <button class="buttons" type="submit">Видалити акаунт</button>
  </form>

  <a href="account.jsp" class="links">Повернутися на сторінку користувача</a>

</div>
</body>
</html>
