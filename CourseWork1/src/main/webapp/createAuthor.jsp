<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <link rel="stylesheet" type="text/css" href="css/stylesMain.css"/>
  <title>Створення автора</title>
</head>
<body>
<h1>Створення автора</h1>
<form action="createAuthor" method="post">
  <label for="name">Ім'я автора:</label>
  <input type="text" id="name" name="name" required><br><br>

  <label for="biography">Біографія:</label>
  <textarea id="biography" name="biography" required></textarea><br><br>

  <label for="country">Країна:</label>
  <input type="text" id="country" name="country" required><br><br>

  <label for="age">Вік:</label>
  <input type="number" id="age" name="age" required><br><br>

  <button class="buttons" type="submit">Створити автора</button>
</form>
</body>
</html>
